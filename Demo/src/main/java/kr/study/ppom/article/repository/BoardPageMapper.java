package kr.study.ppom.article.repository;

import java.util.List;

import kr.study.ppom.article.dto.ArticleDto;
import kr.study.ppom.article.dto.BoardDto;
import kr.study.ppom.article.dto.CDDto;

public interface BoardPageMapper {
	List<CDDto> getGNBList();
	List<CDDto> getLNBListByGNBId (String clickedCategory);
	List<BoardDto> getArticleListAll();	
	List<BoardDto> getArticleListInLNB( String lnb );
	List<BoardDto> getArticleListInGNB( String gnb);
	
	int insertArticle( ArticleDto article );
}
