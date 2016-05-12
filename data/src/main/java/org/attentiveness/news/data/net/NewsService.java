package org.attentiveness.news.data.net;

import org.attentiveness.news.data.entity.ChannelEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 *
 */
public interface NewsService {

    String API_BASE_URL = "http://apis.baidu.com/showapi_open_bus/channel_news/";

    String API_KEY = "bd143596a597f6b6ee418848d44b4ae6";

    @Headers("apikey: bd143596a597f6b6ee418848d44b4ae6")
    @GET("channel_news")
    Call<ChannelEntity> getChannelList();
}
