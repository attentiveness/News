package org.attentiveness.news.list;

import android.support.annotation.NonNull;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.Story;

import java.util.List;

interface StoryListContract {

    interface View extends BaseView<Presenter> {

        void showStoryList(List<Story> storyList);

        void appendStoryList(List<Story> storyList);

        void hideStoryList();

        void setLoadingIndicator(boolean active);

        void showRetry();

        void hideRetry();

        void showError(String message);

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadNewsList(@NonNull String date, boolean forceUpdate, boolean append);

    }

}
