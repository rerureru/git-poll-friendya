package kr.study.ppom.service;

import java.util.List;

import kr.study.ppom.common.BoardPagePartName;
import kr.study.ppom.dao.BoardPageDao;
import kr.study.ppom.dto.BoardDto;
import kr.study.ppom.model.ArticleListModel;
import kr.study.ppom.model.BoardPageModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardPageServiceImpl implements BoardPageService {
	private static final Logger logger = LoggerFactory.getLogger(BoardPageServiceImpl.class);
	
	@Autowired
	private BoardPageDao boardPageDao;
	
	@Override
	public BoardPageModel getBoardPageModel(String clickedGNB, String clickedLNB) {
		BoardPageModel boardPageModel = new BoardPageModel();
				 
		ArticleListModel articleListModel = new ArticleListModel();
		articleListModel.setArticleList( getArticleList( clickedGNB, clickedLNB) );
		articleListModel.setArticleTotalCount( boardPageDao.getCount(clickedGNB, clickedLNB ) );
			
		boardPageModel.addModel( BoardPagePartName.BoardContent, articleListModel );
		
		return boardPageModel;
	}

	private List<BoardDto> getArticleList( String gnb, String lnb ) {
		List<BoardDto> boardList = null;
		
		if(gnb == null ) {
			boardList = boardPageDao.lookupArticleListAll();
		} else if(lnb == null || "0".equals(lnb)) {
			boardList = boardPageDao.lookupArticleListInGNB(gnb);
		} else {
			boardList = boardPageDao.lookupArticleListInLNB(lnb);
			
		}
		return boardList;
	}	
}
