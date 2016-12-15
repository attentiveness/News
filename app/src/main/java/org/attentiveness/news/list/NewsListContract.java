package org.attentiveness.news.list;


import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.DailyNews;
import org.attentiveness.news.data.News;

import java.util.List;

interface NewsListContract {

    interface View extends BaseView {
        void saveTotalPage(int totalPage);

        void renderFirstPage(List<News> newsList);

        void appendPage(List<News> newsList);

        void showError(String message);

        void showNews(DailyNews news);
    }

    interface Presenter extends BasePresenter {
        void getTotalPage(String channelId);

        void getNewsList(boolean forceRefresh, String channelId, int currentPage, int needContent, int needHtml);

        void getNewsList();
    }

}
