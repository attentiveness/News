package org.attentiveness.news.detail;

import org.attentiveness.news.data.source.StoriesDataRepository;

class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private StoriesDataRepository mRepository;
    private NewsDetailContract.View mView;

    NewsDetailPresenter(StoriesDataRepository repository, NewsDetailContract.View view) {
        this.mRepository = repository;
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void openNewsDetail(int storyId) {

    }
}
