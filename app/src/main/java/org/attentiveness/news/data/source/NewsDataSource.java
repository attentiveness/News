package org.attentiveness.news.data.source;


import org.attentiveness.news.data.News;

import java.util.List;

import rx.Observable;

public interface NewsDataSource {

    Observable<List<News>> getNewsList(String channelId, int currentPage, int needContent, int needHtml);

    Observable<News> getNews(String newsId, String title);

    void saveNews(News news);

    void deleteNews(String newsId, String title);

    void deleteAllNews();

    void refreshNewsList();

    Observable<Integer> getTotalPage(String channelId);
}
