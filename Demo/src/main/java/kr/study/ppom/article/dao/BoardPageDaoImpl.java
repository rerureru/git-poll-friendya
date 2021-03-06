package kr.study.ppom.article.dao;

import java.util.List;

import kr.study.ppom.article.dto.BoardDto;
import kr.study.ppom.article.dto.CDDto;
import kr.study.ppom.article.repository.BoardPageMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class  BoardPageDaoImpl implements BoardPageDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CDDto> lookupGlobalNavigationBar() {
		return sqlSession.getMapper(BoardPageMapper.class).getGNBList();
	}

	@Override
	public List<CDDto> lookupLocalNavigationBar(String gnb) {
		return sqlSession.getMapper(BoardPageMapper.class).getLNBListByGNBId(gnb);
	}

	@Override
	public List<BoardDto> lookupArticleListAll() {
		return sqlSession.getMapper(BoardPageMapper.class).getArticleListAll();
	}

	@Override
	public List<BoardDto> lookupArticleListInGNB(String gnb) {
		return sqlSession.getMapper(BoardPageMapper.class).getArticleListInGNB(gnb);
	}

	@Override
	public List<BoardDto> lookupArticleListInLNB(String lnb) {
		return sqlSession.getMapper(BoardPageMapper.class).getArticleListInLNB(lnb);
	}

	@Override
	public int getArticleCount(String clickedGNB, String clickedLNB) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertArticle(BoardDto article) {
		return sqlSession.getMapper(BoardPageMapper.class).insertArticle(article);
	}

	@Override
	public BoardDto selectArticle(String articleId) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BoardPageMapper.class).selectArticle(articleId);
	}	
}
