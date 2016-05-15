package org.attentiveness.news.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import org.attentiveness.news.domain.bean.Channel;
import org.attentiveness.news.domain.exception.DefaultErrorBundle;
import org.attentiveness.news.domain.exception.ErrorBundle;
import org.attentiveness.news.domain.interactor.DefaultSubscriber;
import org.attentiveness.news.domain.interactor.UseCase;
import org.attentiveness.news.exception.ErrorMessageFactory;
import org.attentiveness.news.view.NewsListView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * News List Presenter
 */
public class NewsListPresenter implements Presenter {

    private UseCase mUseCase;
    private NewsListView mNewsListView;

    @Inject
    public NewsListPresenter(@Named("channelList") UseCase getChannelList) {
        this.mUseCase = getChannelList;
    }

    public void setView(@NonNull NewsListView newsListView) {
        this.mNewsListView = newsListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mUseCase.unsubscribe();
        mNewsListView = null;
    }

    public void init() {
        mUseCase.execute(new NewsListSubscriber());
    }

    private void showViewLoading() {
        mNewsListView.showLoading();
    }

    private void hideViewLoading() {
        mNewsListView.hideLoading();
    }

    private void showViewRetry() {
        mNewsListView.showRetry();
    }

    private void hideViewRetry() {
        mNewsListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String message = ErrorMessageFactory.create(mNewsListView.context(), errorBundle.getException());
        mNewsListView.showError(message);
    }

    private class NewsListSubscriber extends DefaultSubscriber<List<Channel>> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideViewLoading();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            showViewRetry();
        }

        @Override
        public void onNext(List<Channel> channels) {
            Log.e("NewsListPresenter", "channel count: " + channels.size());
        }
    }

}
