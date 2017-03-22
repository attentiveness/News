package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.News;

public class NewsListPresenter implements NewsListContract.Presenter {

    private NewsListContract.View mNewsListView;

    public NewsListPresenter(NewsListContract.View view) {
        this.mNewsListView = view;
        this.mNewsListView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadNews(boolean forceUpdate) {

    }

    @Override
    public void openNewsDetails(@NonNull News requestedNews) {

    }
}
