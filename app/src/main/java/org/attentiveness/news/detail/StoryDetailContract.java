package org.attentiveness.news.detail;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;
import org.attentiveness.news.data.StoryDetail;

interface StoryDetailContract {

    interface View extends BaseView<Presenter> {

        void showStoryDetail(StoryDetail comment);

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

    }
}
