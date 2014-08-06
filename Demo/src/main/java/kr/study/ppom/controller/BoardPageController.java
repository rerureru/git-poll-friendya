package kr.study.ppom.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.study.ppom.article.dto.ArticleDto;
import kr.study.ppom.article.dto.CDDto;
import kr.study.ppom.article.model.ArticleListModel;
import kr.study.ppom.article.model.PageNavigationBarModel;
import kr.study.ppom.article.service.BoardPageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
		
		
		PageNavigationBarModel pageNavigationBarModel = 
				boardPageService.getPageNavigationBarModel(clickedGNB, clickedLNB);
		ArticleListModel articleListModel = 
				boardPageService.getArticleListModel( clickedGNB, clickedLNB );
				
		ModelAndView boardMAV = new ModelAndView();
		boardMAV.addObject("boardGNB", pageNavigationBarModel.getGlobalNavigationBar());
		boardMAV.addObject("boardLNB", pageNavigationBarModel.getLocalNavigationBar());
		boardMAV.addObject("selectedMenu", pageNavigationBarModel.getSelectedMenu());
		boardMAV.addObject("boardContent", articleListModel);
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
	
	@RequestMapping("/newArticle.action")
	public ModelAndView newArticleForm(){ 
		ModelAndView articleCreateMAV = new ModelAndView();
		List<CDDto> cDDtoList = boardPageService.getPageGlobalNavigationBarModel();
		logger.info("[controller] : " + cDDtoList);
		articleCreateMAV.addObject("boardGNB", cDDtoList);
		articleCreateMAV.setViewName("jsp/board/newArticle");
		return articleCreateMAV;
	}
	
	@RequestMapping(value="/submitArticle.action", method=RequestMethod.POST)
	public ModelAndView submitArticle( 
			ArticleDto article, 
			HttpServletRequest request, 
			Principal principal ){ 
		logger.info("[controller] : " + article + ", username : " + principal.getName() );
		article.setCreator(principal.getName());
		boardPageService.insertArticle( article );
		
		RedirectView articleCreateCompleteRV = new RedirectView(request.getContextPath() +"/boardList.action");
		articleCreateCompleteRV.setExposeModelAttributes(false);
		return new ModelAndView(articleCreateCompleteRV);
	}
	
	@RequestMapping(value="/board/menu/gnb/{gnbId}/lnb", method=RequestMethod.GET)
	public @ResponseBody
	List<CDDto> queryLNBListByGNBId(@PathVariable String gnbId ) {
		logger.info("queryLNBListByGNBId!! : " + gnbId);
		List<CDDto> menuInfoList = boardPageService.getPagelocalNavigationBarModel( gnbId );
		logger.info("queryLNBListByGNBId!! : " + menuInfoList);
		return menuInfoList;		
	}
}
