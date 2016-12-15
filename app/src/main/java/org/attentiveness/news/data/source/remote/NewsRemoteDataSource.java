package org.attentiveness.news.data.source.remote;


import org.attentiveness.news.data.DailyNews;
import org.attentiveness.news.data.News;
import org.attentiveness.news.data.source.NewsDataSource;
import org.attentiveness.news.net.RestApi;

import java.util.List;

import rx.Observable;

public class NewsRemoteDataSource implements NewsDataSource {

    private static NewsRemoteDataSource INSTANCE = null;

    private RestApi mRestApi;

    private NewsRemoteDataSource() {
        this.mRestApi = RestApi.getInstance();
    }

    public static NewsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewsRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<News>> getNewsList(String channelId, int currentPage, int needContent, int needHtml) {
        return mRestApi.getNewsList(channelId, currentPage, needContent, needHtml);
    }

    @Override
    public Observable<News> getNews(String newsId, String title) {
        return Observable.just(null);
    }

    @Override
    public void saveNews(News news) {

    }

    @Override
    public void deleteNews(String newsId, String title) {

    }

    @Override
    public void deleteAllNews() {

    }

    @Override
    public void refreshNewsList() {

    }

    @Override
    public Observable<Integer> getTotalPage(String channelId) {
        return mRestApi.getTotalPages(channelId);
    }

    @Override
    public Observable<DailyNews> getNewsList() {
        return mRestApi.getNewsList();
    }
}
