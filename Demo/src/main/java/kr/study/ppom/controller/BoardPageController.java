package kr.study.ppom.controller;

import kr.study.ppom.common.BoardPagePartName;
import kr.study.ppom.model.BoardPageModel;
import kr.study.ppom.service.BoardPageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardPageController {
	@Autowired
	private BoardPageService boardPageService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardPageController.class);

	@RequestMapping("/boardList.action")
	public ModelAndView lookupBoardList(
			@RequestParam(value="gnb", required=false) String clickedGNB, 
			@RequestParam(value="lnb",required=false) String clickedLNB ) {
		logger.info("BoardPageService Called");
		BoardPageModel boardPageModel = 
				boardPageService.getBoardPageModel( clickedGNB, clickedLNB );
				
		ModelAndView boardMAV = new ModelAndView();
		boardMAV.addObject("boardGNB", boardPageModel.getModel( BoardPagePartName.GlobalNavigationBar));
		boardMAV.addObject("boardLNB", boardPageModel.getModel( BoardPagePartName.LocalNavigationBar));
		boardMAV.addObject("boardContent", boardPageModel.getModel(BoardPagePartName.BoardContent));
		boardMAV.addObject("selectedMenu", boardPageModel.getModel(BoardPagePartName.SelecetedMenu));
		boardMAV.setViewName("jsp/board/boardList");
		
		return boardMAV;
	}
	
	@RequestMapping("/articleDetail.action")
	public ModelAndView showArticleDetail(
			@RequestParam(value="boardId") String articleId){ 
		logger.info("showArticleDetail Called : " + articleId);
		ModelAndView articleMAV = new ModelAndView();
		articleMAV.setViewName("home");
		return articleMAV;
	}
}
