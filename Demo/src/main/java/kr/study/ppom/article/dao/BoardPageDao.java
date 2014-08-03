package kr.study.ppom.article.dao;

import java.util.List;

import kr.study.ppom.article.dto.BoardDto;
import kr.study.ppom.article.dto.CDDto;

public interface BoardPageDao {

	List<CDDto> lookupGlobalNavigationBar();
	List<CDDto> lookupLocalNavigationBar(String gnb);
	
	List<BoardDto> lookupSelectedBoardContents(String categoryType,
			String clickedCategory);
	List<BoardDto> lookupArticleListAll();
	List<BoardDto> lookupArticleListInGNB(String gnb);
	List<BoardDto> lookupArticleListInLNB(String lnb);
	int getArticleCount(String clickedGNB, String clickedLNB);
}
