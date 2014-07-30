package kr.study.ppom.article.service;

import kr.study.ppom.article.model.ArticleListModel;
import kr.study.ppom.article.model.PageNavigationBarModel;

public interface BoardPageService {
	ArticleListModel getArticleListModel(String clickedGNB, String clickedLNB);

	PageNavigationBarModel getPageNavigationBarModel(String clickedGNB,
			String clickedLNB);

}
