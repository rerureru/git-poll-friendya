package net.nice19.smboard.board.service;

import java.util.List;
import java.util.prefs.BackingStoreException;

import net.nice19.smboard.board.dao.BoardDao;
import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;
import net.nice19.smboard.login.dao.LoginDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private LoginDao loginDato;
	@Override
	public List<BoardModel> getBoardList(int startArticleNum,
			int showArticleLimit) {
		return boardDao.getBoardList(startArticleNum, showArticleLimit);
	}

	@Override
	public BoardModel getOneArticle(int idx) {
		return boardDao.getOneArticle(idx);
	}

	@Override
	public List<BoardModel> searchArticle(String type, String keyword,
			int startArticleNum, int endArticleNum) {
		return boardDao.searchArticle(type, keyword, startArticleNum, endArticleNum);
	}

	@Override
	public List<BoardCommentModel> getCommentList(int idx) {
		return boardDao.getCommentList(idx);
	}

	@Override
	public BoardCommentModel getOneComment(int idx) {
		return boardDao.getOneComment(idx);
	}

	@Override
	public boolean modifyArticle(BoardModel board) {
		return boardDao.modifyArticle(board);
	}

	@Override
	public boolean writeArticle(BoardModel board) {
		return boardDao.writeArticle(board);
	}

	@Override
	public boolean writeComment(BoardCommentModel comment) {
		return boardDao.writeComment(comment);
	}

	@Override
	public void updateHitcount(int hitcount, int idx) {
		boardDao.updateHitcount(hitcount, idx);		
	}

	@Override
	public void updateRecommendCount(int recommendcount, int idx) {
		boardDao.updateRecommendCount(recommendcount, idx);		
	}

	@Override
	public int getTotalNum() {
		return boardDao.getTotalNum();
	}

	@Override
	public int getSearchTotalNum(String type, String keyword) {
		return boardDao.getSearchTotalNum(type, keyword);
	}

	@Override
	public void deleteComment(int idx) {
		boardDao.deleteComment(idx);
	}

	@Override
	public void deleteArticle(int idx) {
		boardDao.deleteArticle(idx);
	}
	

}
