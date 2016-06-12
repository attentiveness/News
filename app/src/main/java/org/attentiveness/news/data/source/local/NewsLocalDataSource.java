package org.attentiveness.news.data.source.local;


import android.content.Context;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.source.NewsDataSource;

import java.util.List;

import rx.Observable;

public class NewsLocalDataSource implements NewsDataSource {

    private static NewsLocalDataSource INSTANCE = null;

    private NewsDao mNewsDao;

    private NewsLocalDataSource(Context context) {
        this.mNewsDao = NewsDao.getInstance(context);
    }

    public static NewsLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new NewsLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<News>> getNewsList(String channelId, int currentPage, int needContent, int needHtml) {
        return Observable.just(mNewsDao.queryByChannel(channelId));
    }

    @Override
    public Observable<News> getNews(String newsId, String title) {
        return Observable.just(mNewsDao.query(newsId, title));
    }

    @Override
    public void saveNews(News news) {
        if (mNewsDao.query(news.getId(), news.getTitle()) == null) {
            mNewsDao.insert(news);
        } else {
            mNewsDao.update(news);
        }
    }

    @Override
    public void deleteNews(String newsId, String title) {
        mNewsDao.delete(newsId, title);
    }

    @Override
    public void deleteAllNews() {
        mNewsDao.deleteAll();
    }

    @Override
    public void refreshNewsList() {
        //do nothing
    }

    @Override
    public Observable<Integer> getTotalPage(String channelId) {
        return Observable.just(0);
    }
}
