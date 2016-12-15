package org.attentiveness.news.list;


import android.content.Context;

import org.attentiveness.news.base.UseCase;
import org.attentiveness.news.data.source.NewsRepository;

import rx.Subscriber;
import rx.schedulers.Schedulers;

class NewsListUseCase extends UseCase {

    private NewsRepository mRepository;

    NewsListUseCase(Context context) {
        super();
        this.mRepository = NewsRepository.getInstance(context);
    }

    @SuppressWarnings("unchecked")
    void getTotalPage(String channelId, Subscriber subscriber) {
        mSubscription = mRepository.getTotalPage(channelId)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    @SuppressWarnings("unchecked")
    public void getNewsList(String channelId, int currentPage, int needContent, int needHtml, Subscriber subscriber) {
        mSubscription = mRepository.getNewsList(channelId, currentPage, needContent, needHtml)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    void refresh() {
        mRepository.refreshNewsList();
    }

    @SuppressWarnings("unchecked")
    public void getNewsList(Subscriber subscriber) {
        mSubscription = mRepository.getNewsList()
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

}
