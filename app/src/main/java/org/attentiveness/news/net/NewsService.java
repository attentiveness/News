package org.attentiveness.news.net;


import org.attentiveness.news.data.ApiResponse;
import org.attentiveness.news.data.ChannelPage;
import org.attentiveness.news.data.DailyNews;
import org.attentiveness.news.data.NewsPage;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

interface NewsService {

    String API_KEY = "bd143596a597f6b6ee418848d44b4ae6";

    @Headers("apikey: " + API_KEY)
    @GET("search_news")
    Observable<ApiResponse<NewsPage>> getNewsList(@Query("channelId") String channelId, @Query("page") int currentPage,
                                                  @Query("needContent") int needContent, @Query("needHtml") int needHtml);

    @Headers("apikey: " + API_KEY)
    @GET("search_news")
    Observable<ApiResponse<NewsPage>> getNewsList(@Query("channelId") String channelId);

    @Headers("apikey: " + API_KEY)
    @GET("channel_news")
    Observable<ApiResponse<ChannelPage>> getChannelList();

    @GET("latest")
    Observable<DailyNews> getNewsList();

}
