package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataRepository;
import org.attentiveness.news.data.source.StoriesDataSource;

import java.util.List;

class NewsListPresenter implements NewsListContract.Presenter {

    private StoriesDataRepository mRepository;
    private NewsListContract.View mNewsListView;
    private boolean mFirstLoad = true;

    NewsListPresenter(StoriesDataRepository repository, NewsListContract.View view) {
        this.mRepository = repository;
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
            this.mNewsListView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            this.mRepository.refreshStories();
        }
        this.mRepository.getStories(new StoriesDataSource.LoadStoriesCallback() {
            @Override
            public void onStoriesLoaded(List<Story> stories) {
                if (!mNewsListView.isActive()) {
                    return;
                }
                if (showLoadingUI) {
                    mNewsListView.setLoadingIndicator(false);
                }
                mNewsListView.showStoryList(stories);
            }

            @Override
            public void onDataNotAvailable() {
                if (!mNewsListView.isActive()) {
                    return;
                }
                mNewsListView.showLoadingNewsError();
            }
        });
    }

    @Override
    public void openNewsDetails(@NonNull News requestedNews) {

    }
}
