package org.attentiveness.news.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.attentiveness.news.R;
import org.attentiveness.news.data.News;
import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;
import org.attentiveness.news.exception.NetworkException;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Http Manager that responds to url request.
 */
public class HttpManager {

    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/news/";

    private static HttpManager INSTANCE = null;

    private Context mContext;
    private StoryService mStoryService;

    public static HttpManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new HttpManager(context);
        }
        return INSTANCE;
    }

    /**
     * Both connection time and read time are 10,000ms by default.
     */
    private HttpManager(Context context) {
        this.mContext = context;
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.mStoryService = retrofit.create(StoryService.class);
    }

    public Observable<List<Story>> getStoryList(String date) {
        if (!this.isConnected()) {
            return Observable.error(new Callable<Throwable>() {
                @Override
                public Throwable call() {
                    return new NetworkException(mContext.getResources().getString(R.string.error_no_network_connection));
                }
            });
        }
        return this.mStoryService.getStoryList(date).map(new Function<News, List<Story>>() {
            @Override
            public List<Story> apply(@NonNull News news) throws Exception {
                return news.getStoryList();
            }
        });
    }

    public Observable<StoryDetail> getStory(int storyId) {
        if (!this.isConnected()) {
            return Observable.error(new Callable<Throwable>() {
                @Override
                public Throwable call() {
                    return new NetworkException(mContext.getResources().getString(R.string.error_no_network_connection));
                }
            });
        }
        return this.mStoryService.getStoryDetail(storyId);
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}
