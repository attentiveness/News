package org.attentiveness.news.net;


import android.util.Log;

import org.attentiveness.news.data.ApiResponseFunc;
import org.attentiveness.news.data.Channel;
import org.attentiveness.news.data.ChannelPage;
import org.attentiveness.news.data.News;
import org.attentiveness.news.data.NewsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class RestApi {

    private final static String BASE_URL = "http://apis.baidu.com/showapi_open_bus/channel_news/";
    private final static int DEFAULT_TIMEOUT = 5;

    private static RestApi INSTANCE = null;

    private NewsService mNewsService;

    private RestApi() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        client.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        this.mNewsService = retrofit.create(NewsService.class);
    }

    public static RestApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RestApi();
        }
        return INSTANCE;
    }

    public Observable<List<News>> getNewsList(String channelId, int currentPage, int needContent, int needHtml) {
        return mNewsService.getNewsList(channelId, currentPage, needContent, needHtml).map(new ApiResponseFunc<NewsPage>())
                .map(new Func1<NewsPage, List<News>>() {
                    @Override
                    public List<News> call(NewsPage page) {
                        return page.getBody().getNewsList();
                    }
                });
    }

    public Observable<Integer> getTotalPages(String channelId) {
        return mNewsService.getNewsList(channelId).map(new ApiResponseFunc<NewsPage>())
                .map(new Func1<NewsPage, Integer>() {
                    @Override
                    public Integer call(NewsPage page) {
                        return page.getBody().getTotalPagesNum();
                    }
                });
    }

    public Observable<List<Channel>> getChannelList() {
        return mNewsService.getChannelList().map(new ApiResponseFunc<ChannelPage>())
                .map(new Func1<ChannelPage, List<Channel>>() {
                    @Override
                    public List<Channel> call(ChannelPage channelPage) {
                        Log.e(RestApi.class.getSimpleName(), channelPage.toString());
                        return channelPage.getChannelList();
                    }
                });
    }

}
