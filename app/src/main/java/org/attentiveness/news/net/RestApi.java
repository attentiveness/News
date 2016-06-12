package org.attentiveness.news.net;


import org.attentiveness.news.data.ApiResponseFunc;
import org.attentiveness.news.data.News;
import org.attentiveness.news.data.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class RestApi {

    final static String BASE_URL = "http://apis.baidu.com/showapi_open_bus/channel_news/";
    final static int DEFAULT_TIMEOUT = 5;

    private static RestApi INSTANCE = null;

    private NewsService mNewsService;

    private RestApi() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
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
        return mNewsService.getNewsList(channelId, currentPage, needContent, needHtml).map(new ApiResponseFunc<Page>())
                .map(new Func1<Page, List<News>>() {
                    @Override
                    public List<News> call(Page page) {
                        return page.getBody().getNewsList();
                    }
                });
    }

    public Observable<Integer> getTotalPages(String channelId) {
        return mNewsService.getNewsList(channelId).map(new ApiResponseFunc<Page>())
                .map(new Func1<Page, Integer>() {
                    @Override
                    public Integer call(Page page) {
                        return page.getBody().getTotalPagesNum();
                    }
                });
    }

}
