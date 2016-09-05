package org.attentiveness.news.list;


import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.News;

import java.util.List;

public interface NewsListContract {

    interface View extends BaseView {
        void saveTotalPage(int totalPage);

        void renderNewsList(List<News> newsList);

        void appendNewsList(List<News> newsList);

        void showError(String message);
    }

    interface Presenter extends BasePresenter {
        void getTotalPage(String channelId);

        void getNewsList(boolean forceRefresh, String channelId, int currentPage, int needContent, int needHtml);
    }

}
