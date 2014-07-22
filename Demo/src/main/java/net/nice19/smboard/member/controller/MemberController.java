package net.nice19.smboard.member.controller;

import net.nice19.smboard.member.dao.MemberDao;
import net.nice19.smboard.member.model.MemberModel;
import net.nice19.smboard.member.service.MemberValidatior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberService;
	
	@RequestMapping("/join.do")
	public String memberJoin(){
		return "/board/join";
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("MemberModel") MemberModel memberModel, BindingResult result){
		ModelAndView mav = new ModelAndView();
		new MemberValidatior().validate(memberModel, result);
		if(result.hasErrors()){
			mav.setViewName("/board/join");
			return mav;
		}
		
		MemberModel checkMemberModel = memberService.findByUserId(memberModel.getUserId());
		
		if(checkMemberModel != null){
			mav.addObject("errCode", 1); // userId already exist 
			mav.setViewName("/board/join");
			return mav;
		}		
		
		if(memberService.addMember(memberModel)){
			mav.addObject("errCode", 3);
			mav.setViewName("/board/login"); // success to add new member; move to login page
			return mav;
		} else {
			mav.addObject("errCode", 2); // failed to add new member
			mav.setViewName("/board/join");
			return mav;
		}
	}
}
