package org.attentiveness.news.detail;

import android.support.annotation.NonNull;

public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.View mView;

    public NewsDetailPresenter(NewsDetailContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void openNewsDetail(@NonNull String url) {

    }
}
