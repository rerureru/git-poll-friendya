package kr.study.ppom.dao;

import java.util.List;

import kr.study.ppom.dto.BoardDto;
import kr.study.ppom.dto.CDDto;

public interface BoardPageDao {

	List<CDDto> lookupGlobalNavigationBar();
	List<CDDto> lookupLocalNavigationBar(String gnb);
	
	List<BoardDto> lookupSelectedBoardContents(String categoryType,
			String clickedCategory);
	List<BoardDto> lookupArticleListAll();
	List<BoardDto> lookupArticleListInGNB(String gnb);
	List<BoardDto> lookupArticleListInLNB(String lnb);
	int getCount(String clickedGNB, String clickedLNB);
}
