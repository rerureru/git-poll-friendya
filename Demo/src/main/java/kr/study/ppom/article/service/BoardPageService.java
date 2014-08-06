package kr.study.ppom.article.service;

import java.util.List;

import kr.study.ppom.article.dto.CDDto;
import kr.study.ppom.article.model.ArticleListModel;
import kr.study.ppom.article.model.PageNavigationBarModel;

public interface BoardPageService {
	ArticleListModel getArticleListModel(String clickedGNB, String clickedLNB);

	PageNavigationBarModel getPageNavigationBarModel(String clickedGNB,
			String clickedLNB);

	List<CDDto> getPageGlobalNavigationBarModel();

	List<CDDto> getPagelocalNavigationBarModel(String gnbId);

}
