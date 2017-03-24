package org.attentiveness.news.net;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Http Manager that responds to url request.
 */
public class HttpManager {

    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/news/";

    private static HttpManager INSTANCE = null;

    private OkHttpClient mClient;

    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HttpManager();
        }
        return INSTANCE;
    }

    private HttpManager() {
        this.mClient = new OkHttpClient();
        this.mClient.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        this.mClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public void getStoryList(@NonNull final StoriesDataSource.LoadStoriesCallback callback) {
        String url = BASE_URL + "latest"; // get latest news
        Request request = new Request.Builder().url(url).build();
        Call call = this.mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                List<Story> storyList = parseStoryList(response);
                if (storyList == null || storyList.size() == 0) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onStoriesLoaded(storyList);
                }
            }
        });
    }

    public void getStory(int storyId, @NonNull final StoriesDataSource.GetStoryCallback callback) {
        String url = BASE_URL + storyId;
        Request request = new Request.Builder().url(url).build();
        Call call = this.mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Story story = parseStory(response);
                if (story == null) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onStoryLoaded(story);
                }
            }
        });
    }

    private List<Story> parseStoryList(Response response) {
        if (response == null) {
            return null;
        }
        int code = response.code();
        if (code != 200) {
            return null;
        }
        try {
            String resultJson = response.body().string();
            News news = new Gson().fromJson(resultJson, News.class);
            if (news != null) {
                return news.getStoryList();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Story parseStory(Response response) {
        if (response == null) {
            return null;
        }
        int code = response.code();
        if (code != 200) {
            return null;
        }
        try {
            String resultJson = response.body().string();
            Story story = new Gson().fromJson(resultJson, Story.class);
            if (story != null) {
                return story;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
