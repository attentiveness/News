package org.attentiveness.news.detail;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.StoryDetail;
import org.attentiveness.news.data.source.StoriesDataRepository;
import org.attentiveness.news.util.schedulers.BaseSchedulerProvider;
import org.attentiveness.news.util.schedulers.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

class StoryDetailPresenter implements StoryDetailContract.Presenter {

    private int mStoryId;
    @NonNull
    private StoriesDataRepository mRepository;
    @NonNull
    private StoryDetailContract.View mView;
    private CompositeDisposable mDisposables;
    private BaseSchedulerProvider mSchedulerProvider;

    StoryDetailPresenter(int storyId, @NonNull StoriesDataRepository repository, @NonNull StoryDetailContract.View view) {
        this.mStoryId = storyId;
        this.mRepository = repository;
        this.mView = view;
        this.mDisposables = new CompositeDisposable();
        this.mSchedulerProvider = SchedulerProvider.getInstance();
        this.mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        this.requestStoryDetail(this.mStoryId);
    }

    @Override
    public void unsubscribe() {
        this.mDisposables.clear();
    }

    private void requestStoryDetail(int storyId) {
        this.mRepository.getStoryDetail(storyId).subscribeOn(this.mSchedulerProvider.io())
                .observeOn(this.mSchedulerProvider.ui())
                .subscribe(
                        new Consumer<StoryDetail>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull StoryDetail storyDetail) throws Exception {
                                mView.showStoryDetail(storyDetail);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                                mView.showError(throwable.getMessage());
                            }
                        }
                );
    }

}
