package kr.study.ppom.article.model;

import java.util.List;

import kr.study.ppom.article.dto.BoardDto;


public class ArticleListModel {
	private List<BoardDto> articleList;
	private int articleTotalCount;
	
	public List<BoardDto> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<BoardDto> articleList) {
		this.articleList = articleList;
	}
	
	public int getArticleTotalCount() {
		return articleTotalCount;
	}
	
	public void setArticleTotalCount(int count) {
		this.articleTotalCount = count;
		
	}
	
	@Override
	public String toString() {
		return "ArticleListModel [articleList=" + articleList
				+ ", articleCount=" + articleTotalCount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleTotalCount;
		result = prime * result
				+ ((articleList == null) ? 0 : articleList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleListModel other = (ArticleListModel) obj;
		if (articleTotalCount != other.articleTotalCount)
			return false;
		if (articleList == null) {
			if (other.articleList != null)
				return false;
		} else if (!articleList.equals(other.articleList))
			return false;
		return true;
	}
	
		
}
