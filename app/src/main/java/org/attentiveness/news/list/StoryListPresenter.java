package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataRepository;
import org.attentiveness.news.util.DateUtil;
import org.attentiveness.news.util.schedulers.BaseSchedulerProvider;
import org.attentiveness.news.util.schedulers.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

class StoryListPresenter implements StoryListContract.Presenter {

    @NonNull
    private StoriesDataRepository mRepository;
    @NonNull
    private StoryListContract.View mNewsListView;
    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NonNull
    private CompositeDisposable mDisposables;
    private boolean mFirstLoad = true;

    StoryListPresenter(@NonNull StoriesDataRepository repository, @NonNull StoryListContract.View view) {
        this.mRepository = repository;
        this.mNewsListView = view;
        this.mSchedulerProvider = SchedulerProvider.getInstance();
        this.mDisposables = new CompositeDisposable();
        this.mNewsListView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        String today = DateUtil.getToday();
        this.loadNewsList(today, false, false);
    }

    @Override
    public void unsubscribe() {
        this.mDisposables.clear();
    }

    @Override
    public void loadNewsList(@NonNull String date, boolean forceUpdate, boolean append) {
        this.loadNewsList(date, forceUpdate || this.mFirstLoad, true, append);
        this.mFirstLoad = false;
    }

    private void loadNewsList(@NonNull String date, boolean forceUpdate, final boolean showLoadingUI, final boolean append) {
        if (showLoadingUI) {
            this.mNewsListView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            this.mRepository.refreshStories();
        }
        Disposable disposable = this.mRepository.getStories(date)
                .subscribeOn(this.mSchedulerProvider.computation())
                .observeOn(this.mSchedulerProvider.ui())
                .subscribe(
                        new Consumer<List<Story>>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull List<Story> storyList) throws Exception {
                                if (append) {
                                    mNewsListView.appendStoryList(storyList);
                                } else {
                                    mNewsListView.showStoryList(storyList);
                                }
                                mNewsListView.hideRetry();
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                                mNewsListView.showError(throwable.getMessage());
                                mNewsListView.showRetry();
                                mNewsListView.hideStoryList();
                                mNewsListView.setLoadingIndicator(false);
                            }
                        },
                        new Action() {
                            @Override
                            public void run() throws Exception {
                                mNewsListView.setLoadingIndicator(false);
                            }
                        });
        this.mDisposables.add(disposable);
    }

}
