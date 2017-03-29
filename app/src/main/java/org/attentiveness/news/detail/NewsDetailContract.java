package org.attentiveness.news.detail;

import android.support.annotation.NonNull;

import org.attentiveness.news.base.BasePresenter;
import org.attentiveness.news.base.BaseView;

public interface NewsDetailContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showNewsDetailUi();

        void showLoadingNewsDetailError();

        void showNoNewsDetail();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void openNewsDetail(@NonNull String url);

    }
}
