package org.attentiveness.news.data.net;

import org.attentiveness.news.data.entity.ApiResponse;
import org.attentiveness.news.data.entity.ChannelInfo;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 *
 */
public interface NewsService {

    String API_KEY = "bd143596a597f6b6ee418848d44b4ae6";

    @Headers("apikey: " + API_KEY)
    @GET("channel_news")
    Observable<ApiResponse<ChannelInfo>> getChannelList();
}
