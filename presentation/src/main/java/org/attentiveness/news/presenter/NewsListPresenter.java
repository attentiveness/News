package org.attentiveness.news.presenter;

import android.support.annotation.NonNull;

import org.attentiveness.news.domain.bean.News;
import org.attentiveness.news.domain.exception.DefaultErrorBundle;
import org.attentiveness.news.domain.exception.ErrorBundle;
import org.attentiveness.news.domain.interactor.DefaultSubscriber;
import org.attentiveness.news.domain.interactor.UseCase;
import org.attentiveness.news.exception.ErrorMessageFactory;
import org.attentiveness.news.internal.di.PerActivity;
import org.attentiveness.news.model.NewsModel;
import org.attentiveness.news.model.mapper.NewsModelDataMapper;
import org.attentiveness.news.view.NewsListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * News List Presenter
 */
@PerActivity
public class NewsListPresenter implements Presenter {

    private NewsModelDataMapper mNewsModelDataMapper;

    private UseCase mUseCase;
    private NewsListView mNewsListView;

    @Inject
    public NewsListPresenter(@Named("newsList") UseCase getNewsList, NewsModelDataMapper newsModelDataMapper) {
        this.mUseCase = getNewsList;
        this.mNewsModelDataMapper = newsModelDataMapper;
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
        loadNewsList();
    }

    private void loadNewsList() {
        showViewLoading();
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

    private void renderNewsList(Collection<News> newsCollection) {
        Collection<NewsModel> newsModelCollection = mNewsModelDataMapper.transform(newsCollection);
        mNewsListView.renderNewsList(newsModelCollection);
    }

    private class NewsListSubscriber extends DefaultSubscriber<List<News>> {

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
        public void onNext(List<News> newsList) {
            hideViewLoading();
            renderNewsList(newsList);
        }
    }

}
