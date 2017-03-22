package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.News;

class NewsListPresenter implements NewsListContract.Presenter {

    private NewsListContract.View mNewsListView;
    private boolean mFirstLoad = true;

    NewsListPresenter(NewsListContract.View view) {
        this.mNewsListView = view;
        this.mNewsListView.setPresenter(this);
    }

    @Override
    public void start() {
        loadNewsList(false);
    }

    @Override
    public void loadNewsList(boolean forceUpdate) {
        loadNewsList(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadNewsList(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
//            this.mNewsListView.setLoadingIndicator(true);
        }
    }

    @Override
    public void openNewsDetails(@NonNull News requestedNews) {

    }
}
