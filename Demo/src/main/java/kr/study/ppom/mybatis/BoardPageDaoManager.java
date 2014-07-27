package kr.study.ppom.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.study.ppom.dto.BoardDto;
import kr.study.ppom.dto.CDDto;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardPageDaoManager {

	private final static Logger logger = LoggerFactory
			.getLogger(BoardPageDaoManager.class);
	private static SqlSessionFactory sqlMapper;

	static {
		try {
			logger.info("BoardPageDaoManager init start..");
			Reader reader = Resources
					.getResourceAsReader("db/mybatis/SqlMapConfig.xml");
			logger.info( "BoardPageDaoManager init success.." );
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException(
					"Something bad happened while building the SqlMapClient instance."
							+ e, e);
		}
	}
	
	public static List<CDDto> getGNB(){
		List<CDDto> result = null;
		logger.info( "BoardPageDaoManager getGNB" );
		
		SqlSession session = sqlMapper.openSession();
		try {
		result = session.selectList( "getGNBList" );
		}finally {
			session.close();
		}

		return result;
	}
	

	public static List<CDDto> getLNBByGNBId(String clickedCategory) {
		List<CDDto> result = null;
		logger.info( "BoardPageDaoManager getLNBByGNBId" );
		
		SqlSession session = sqlMapper.openSession();
		try {
			result = session.selectList( "getLNBListByGNBId", clickedCategory );
		} finally {
			session.close();
		}
		logger.info("result : " + result.toString());

		return result;
	}


	public static List<BoardDto> getArticleListAll() {
		List<BoardDto> result = null;
		logger.info( "BoardPageDaoManager getArticleAll" );
		
		SqlSession session = sqlMapper.openSession();
		try {
			result = session.selectList( "getArticleListAll" );
		} finally {
			session.close();
		}
		logger.info("result : " + result.toString());
	
		return result;
	}


	public static List<BoardDto> getArticleListInLNB(String lnb) {
		List<BoardDto> result = null;
		logger.info( "BoardPageDaoManager getArticleInLNB" );
		
		SqlSession session = sqlMapper.openSession();
		try {
			result = session.selectList( "getArticleListInLNB", lnb );
		} finally {
			session.close();
		}
		logger.info("result : " + result.toString());
	
		return result;
	}
	
	public static List<BoardDto> getArticleListInGNB(String gnb) {
		List<BoardDto> result = null;
		logger.info( "BoardPageDaoManager getArticleInGNB" );
		
		SqlSession session = sqlMapper.openSession();
		try {
			result = session.selectList( "getArticleListInGNB", gnb );
		} finally {
			session.close();
		}
		logger.info("result : " + result.toString());
	
		return result;
	}
	
}
