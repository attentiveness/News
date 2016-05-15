package org.attentiveness.news.data.net;

import org.attentiveness.news.data.entity.ApiResponse;
import org.attentiveness.news.data.entity.ApiResponseFunc;
import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.ChannelInfo;
import org.attentiveness.news.data.entity.NewsEntity;
import org.attentiveness.news.data.entity.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * Rest Api Implementation Class
 */
public class RestApiImpl implements RestApi {

    private final static int DEFAULT_TIMEOUT = 5;

    private NewsService mNewsService;

    private RestApiImpl() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mNewsService = retrofit.create(NewsService.class);
    }

    private static class SingletonHolder {
        private final static RestApiImpl INSTANCE = new RestApiImpl();
    }

    public static RestApiImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Observable<List<ChannelEntity>> getChannelEntityList() {
        Observable<ApiResponse<ChannelInfo>> observable = mNewsService.getChannelList();
        return observable.map(new ApiResponseFunc<ChannelInfo>()).flatMap(mChannelInfoObservableFunc1);
    }

    @Override
    public Observable<List<NewsEntity>> getNewsEntityList() {
        Observable<ApiResponse<PageInfo>> observable = mNewsService.getNewsList("5572a109b3cdc86cf39001e3", 1, 1, 1);
        return observable.map(new ApiResponseFunc<PageInfo>()).flatMap(mPageInfoObservableFunc1);
    }

    private final Func1<ChannelInfo, Observable<List<ChannelEntity>>> mChannelInfoObservableFunc1 = new Func1<ChannelInfo, Observable<List<ChannelEntity>>>() {
        @Override
        public Observable<List<ChannelEntity>> call(ChannelInfo channelInfo) {
            if (channelInfo != null && channelInfo.getChannelEntityList() != null) {
                return Observable.just(channelInfo.getChannelEntityList());
            }
            List<ChannelEntity> list = new ArrayList<>();
            return Observable.just(list);
        }
    };

    private final Func1<PageInfo, Observable<List<NewsEntity>>> mPageInfoObservableFunc1 = new Func1<PageInfo, Observable<List<NewsEntity>>>() {
        @Override
        public Observable<List<NewsEntity>> call(PageInfo pageInfo) {
            List<NewsEntity> list;
            if (pageInfo != null && pageInfo.getPageEntity() != null) {
                list = pageInfo.getPageEntity().getNewsEntityList();
                return Observable.just(list);
            }
            list = new ArrayList<>();
            return Observable.just(list);
        }
    };
}
