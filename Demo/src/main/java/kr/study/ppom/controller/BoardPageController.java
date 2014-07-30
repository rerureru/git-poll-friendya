package kr.study.ppom.controller;

import kr.study.ppom.article.model.ArticleListModel;
import kr.study.ppom.article.model.PageNavigationBarModel;
import kr.study.ppom.article.service.BoardPageService;

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
}
