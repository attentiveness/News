package org.attentiveness.news.net;


import org.attentiveness.news.data.ApiResponse;
import org.attentiveness.news.data.Page;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface NewsService {

    String API_KEY = "bd143596a597f6b6ee418848d44b4ae6";

    @Headers("apikey: " + API_KEY)
    @GET("search_news")
    Observable<ApiResponse<Page>> getNewsList(@Query("channelId") String channelId, @Query("page") int currentPage,
                                              @Query("needContent") int needContent, @Query("needHtml") int needHtml);

    @Headers("apikey: " + API_KEY)
    @GET("search_news")
    Observable<ApiResponse<Page>> getNewsList(@Query("channelId") String channelId);
}
