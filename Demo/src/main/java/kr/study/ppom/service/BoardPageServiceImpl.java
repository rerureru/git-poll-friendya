package kr.study.ppom.service;

import java.util.ArrayList;
import java.util.List;

import kr.study.ppom.dao.BoardPageDao;
import kr.study.ppom.dto.BoardDto;
import kr.study.ppom.dto.CDDto;
import kr.study.ppom.model.ArticleListModel;
import kr.study.ppom.model.PageNavigationBarModel;
import kr.study.ppom.model.SelectedMenu;

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
	public ArticleListModel getArticleListModel(String clickedGNB, String clickedLNB) {				 
		ArticleListModel articleListModel = new ArticleListModel();
		articleListModel.setArticleList( getArticleList( clickedGNB, clickedLNB) );
		articleListModel.setArticleTotalCount( boardPageDao.getCount(clickedGNB, clickedLNB ) );
		
		return articleListModel;
	}
	
	@Override
	public PageNavigationBarModel getPageNavigationBarModel(String gnb,
			String lnb ) {		
		PageNavigationBarModel pageNavigationBarModel = new PageNavigationBarModel();
		
		pageNavigationBarModel.setGlobalNavigationBar(boardPageDao.lookupGlobalNavigationBar());
		pageNavigationBarModel.setLocalNavigationBar(getLocalNavigationBarList( gnb, lnb ));
		pageNavigationBarModel.setSelectedMenu(getSelectedMenu( gnb, lnb ));
		
		return pageNavigationBarModel;
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
	
	private List<CDDto> getLocalNavigationBarList( String gnb, String lnb ) {
		List<CDDto> lnbList = new ArrayList<CDDto>();
		
		CDDto cdDtoTmp = new CDDto();
		cdDtoTmp.setcDKindID(2);
		cdDtoTmp.setcDVal("0");
		cdDtoTmp.setcDName("��ü����");
		
		lnbList.add(cdDtoTmp);
		
		if( (gnb!=null) ) {
			lnbList.addAll( boardPageDao.lookupLocalNavigationBar( gnb) );
		} 

		return lnbList;
	}

	private SelectedMenu getSelectedMenu(String gnb, String lnb) {
		SelectedMenu selectedMenu = new SelectedMenu();
		
		if( gnb == null ) {
			selectedMenu.setSelectedGNBMenuID("0");
			selectedMenu.setSelectedLNBMenuID("0");
		} else if( lnb == null ) {
			logger.info("[service] getSelectedMenu1" + gnb +":" +lnb);
			selectedMenu.setSelectedGNBMenuID(gnb);
			selectedMenu.setSelectedLNBMenuID("0");
		} else {
			logger.info("[service] getSelectedMenu2" + gnb +":" +lnb);
			selectedMenu.setSelectedGNBMenuID( gnb );
			selectedMenu.setSelectedLNBMenuID( lnb );
		} 
		
		return selectedMenu;
	}
}
