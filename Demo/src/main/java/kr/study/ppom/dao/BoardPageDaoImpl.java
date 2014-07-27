package kr.study.ppom.dao;

import java.util.List;

import kr.study.ppom.dto.BoardDto;
import kr.study.ppom.dto.CDDto;
import kr.study.ppom.mybatis.BoardPageDaoManager;

import org.springframework.stereotype.Repository;

@Repository
public class  BoardPageDaoImpl implements BoardPageDao {

	@Override
	public List<CDDto> lookupGlobalNavigationBar(){
		return BoardPageDaoManager.getGNB();
	}

	@Override
	public List<BoardDto> lookupSelectedBoardContents(String categoryType,
			String clickedCategory) {
		return null;
	}

	@Override
	public List<CDDto> lookupLocalNavigationBar(String gnb) {
		List<CDDto> cdDtoList = null;
		
		cdDtoList= BoardPageDaoManager.getLNBByGNBId(gnb);
		
		return cdDtoList;
	}

	@Override
	public List<BoardDto> lookupArticleListAll() {
		List<BoardDto> boardDtoList = null;
		
		boardDtoList = BoardPageDaoManager.getArticleListAll();

		return boardDtoList;
	}

	@Override
	public List<BoardDto> lookupArticleListInGNB(String gnb) {
		List<BoardDto> boardDtoList = null;
		
		boardDtoList = BoardPageDaoManager.getArticleListInGNB(gnb);

		return boardDtoList;
	}

	@Override
	public List<BoardDto> lookupArticleListInLNB(String lnb) {
		List<BoardDto> boardDtoList = null;
		
		boardDtoList = BoardPageDaoManager.getArticleListInLNB(lnb);

		return boardDtoList;
	}

	@Override
	public int getCount(String clickedGNB, String clickedLNB) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
