package org.attentiveness.news.detail;

import org.attentiveness.news.data.source.StoriesDataRepository;

class StoryDetailPresenter implements StoryDetailContract.Presenter {

    private int mStoryId;
    private StoriesDataRepository mRepository;
    private StoryDetailContract.View mView;

    StoryDetailPresenter(int storyId, StoriesDataRepository repository, StoryDetailContract.View view) {
        this.mStoryId = storyId;
        this.mRepository = repository;
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        this.requestStoryDetail(this.mStoryId);
    }

    @Override
    public void unsubscribe() {

    }

    private void requestStoryDetail(int storyId) {

    }

}
