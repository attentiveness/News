package org.attentiveness.news.newslist;


import android.content.Context;

import org.attentiveness.news.base.UseCase;
import org.attentiveness.news.data.source.NewsRepository;

import rx.Subscriber;
import rx.schedulers.Schedulers;

public class NewsListUseCase extends UseCase {

    private NewsRepository mRepository;

    public NewsListUseCase(Context context) {
        super();
        this.mRepository = NewsRepository.getInstance(context);
    }

    @SuppressWarnings("unchecked")
    public void getNewsList(String channelId, int currentPage, int needContent, int needHtml, Subscriber subscriber) {
        mSubscription = mRepository.getNewsList(channelId, currentPage, needContent, needHtml)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    @SuppressWarnings("unchecked")
    public void getTotalPage(String channelId, Subscriber subscriber) {
        mSubscription = mRepository.getTotalPage(channelId)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    public void refresh() {
        mRepository.refreshNewsList();
    }

}
