package org.attentiveness.news.list;

import org.attentiveness.news.data.source.StoriesDataRepository;

class StoryListPresenter implements StoryListContract.Presenter {

    private StoriesDataRepository mRepository;
    private StoryListContract.View mNewsListView;
    private boolean mFirstLoad = true;

    StoryListPresenter(StoriesDataRepository repository, StoryListContract.View view) {
        this.mRepository = repository;
        this.mNewsListView = view;
        this.mNewsListView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadNewsList(false);
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void loadNewsList(boolean forceUpdate) {
        this.loadNewsList(forceUpdate || this.mFirstLoad, true);
        this.mFirstLoad = false;
    }

    private void loadNewsList(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            this.mNewsListView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            this.mRepository.refreshStories();
        }
    }

}
