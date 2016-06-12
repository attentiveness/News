package org.attentiveness.news.data.source;


import android.content.Context;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.source.local.NewsLocalDataSource;
import org.attentiveness.news.data.source.remote.NewsRemoteDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action1;

public class NewsRepository implements NewsDataSource {

    private static NewsRepository INSTANCE = null;

    private NewsDataSource mLocalDataSource;
    private NewsDataSource mRemoteDataSource;
    Map<String, News> mCachedNews;
    boolean mDataIsDirty;

    private NewsRepository(Context context) {
        this.mLocalDataSource = NewsLocalDataSource.getInstance(context);
        this.mRemoteDataSource = NewsRemoteDataSource.getInstance();
        this.mCachedNews = new HashMap<>();
        this.mDataIsDirty = true;
    }

    public static NewsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new NewsRepository(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<News>> getNewsList(String channelId, int currentPage, int needContent, int needHtml) {
        if (!mCachedNews.isEmpty() && !mDataIsDirty) {
            List<News> newsList = new ArrayList<>(mCachedNews.values());
            return Observable.just(newsList);
        }
        if (mDataIsDirty) {
            return getRemoteDataSource(channelId, currentPage, needContent, needHtml);
        } else {
            return getLocalDataSource(channelId, currentPage, needContent, needHtml);
        }
    }

    @Override
    public Observable<News> getNews(String newsId, String title) {
        return mRemoteDataSource.getNews(newsId, title);
    }

    @Override
    public void saveNews(News news) {
        mRemoteDataSource.saveNews(news);
        mLocalDataSource.saveNews(news);
        mCachedNews.put(news.getId(), news);
    }

    @Override
    public void deleteNews(String newsId, String title) {
        mRemoteDataSource.deleteNews(newsId, title);
        mLocalDataSource.deleteNews(newsId, title);
        mCachedNews.remove(newsId);
    }

    @Override
    public void deleteAllNews() {
        mRemoteDataSource.deleteAllNews();
        mLocalDataSource.deleteAllNews();
        mCachedNews.clear();
    }

    @Override
    public void refreshNewsList() {
        mDataIsDirty = true;
    }

    @Override
    public Observable<Integer> getTotalPage(String channelId) {
        return mRemoteDataSource.getTotalPage(channelId);
    }

    private Observable<List<News>> getRemoteDataSource(String channelId, int currentPage, int needContent, int needHtml) {
        return mRemoteDataSource.getNewsList(channelId, currentPage, needContent, needHtml).doOnNext(new Action1<List<News>>() {
            @Override
            public void call(List<News> newsList) {
                refreshCache(newsList);
                refreshLocalData(newsList);
            }
        });
    }

    private Observable<List<News>> getLocalDataSource(String channelId, int currentPage, int needContent, int needHtml) {
        return mLocalDataSource.getNewsList(channelId, currentPage, needContent, needHtml).doOnNext(new Action1<List<News>>() {
            @Override
            public void call(List<News> newsList) {
                refreshCache(newsList);
            }
        });
    }

    private void refreshCache(List<News> newsList) {
        mCachedNews.clear();
        for (News news : newsList) {
            mCachedNews.put(news.getId(), news);
        }
        mDataIsDirty = false;
    }

    private void refreshLocalData(List<News> newsList) {
        mLocalDataSource.deleteAllNews();
        for (News news : newsList) {
            mLocalDataSource.saveNews(news);
        }
    }

}
