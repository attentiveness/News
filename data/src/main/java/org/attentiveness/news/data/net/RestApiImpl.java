package org.attentiveness.news.data.net;

import org.attentiveness.news.data.entity.ApiResponse;
import org.attentiveness.news.data.entity.ApiResponseFunc;
import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.ChannelInfo;

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

    private Retrofit mRetrofit;
    private NewsService mNewsService;

    private RestApiImpl() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mNewsService = mRetrofit.create(NewsService.class);
    }

    private static class SingletonHolder {
        private final static RestApiImpl INSTANCE = new RestApiImpl();
    }

    public static RestApiImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Observable<List<ChannelEntity>> getChannelList() {
        Observable<ApiResponse<ChannelInfo>> observable = mNewsService.getChannelList();
        return observable.map(new ApiResponseFunc<ChannelInfo>()).flatMap(func);
    }

    private final Func1<ChannelInfo, Observable<List<ChannelEntity>>> func = new Func1<ChannelInfo, Observable<List<ChannelEntity>>>() {
        @Override
        public Observable<List<ChannelEntity>> call(ChannelInfo channelInfo) {
            if (channelInfo.getChannelEntityList() != null) {
                return Observable.just(channelInfo.getChannelEntityList());
            }
            List<ChannelEntity> list = new ArrayList<>();
            return Observable.just(list);
        }
    };
}
