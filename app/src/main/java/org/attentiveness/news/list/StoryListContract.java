package org.attentiveness.news.list;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.Story;

import java.util.List;

interface StoryListContract {

    interface View extends BaseView<Presenter> {

        void showStoryList(List<Story> storyList);

        void showNewsMarkedRead();

    }

    interface Presenter extends BasePresenter {

        void loadNewsList(boolean forceUpdate);

    }

}
