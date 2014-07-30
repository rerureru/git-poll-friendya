package kr.study.ppom.service;

import kr.study.ppom.model.ArticleListModel;
import kr.study.ppom.model.PageNavigationBarModel;

public interface BoardPageService {
	ArticleListModel getArticleListModel(String clickedGNB, String clickedLNB);

	PageNavigationBarModel getPageNavigationBarModel(String clickedGNB,
			String clickedLNB);

}
