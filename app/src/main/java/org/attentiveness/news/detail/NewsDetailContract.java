package org.attentiveness.news.detail;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;

interface NewsDetailContract {

    interface View extends BaseView<Presenter> {

        void showNewsDetailUi();

        void showLoadingNewsDetailError();

        void showNoNewsDetail();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void openNewsDetail(int storyId);

    }
}
