package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.News;

import java.util.List;

interface NewsListContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showNewsList(List<News> newsList);

        void showNewsDetailsUi(String url);

        void showNewsMarkedRead();

        void showLoadingNewsError();

        void showNoNews();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadNews(boolean forceUpdate);

        void openNewsDetails(@NonNull News requestedNews);

    }

}
