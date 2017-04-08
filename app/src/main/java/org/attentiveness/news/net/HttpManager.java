package org.attentiveness.news.net;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    /**
     * Both connection time and read time are 10,000ms by default.
     */
    private HttpManager() {
        this.mClient = new OkHttpClient.Builder().build();
    }

    public void getStoryList(@NonNull final StoriesDataSource.LoadStoriesCallback callback) {
        String url = BASE_URL + "latest"; // get latest news
        Request request = new Request.Builder().url(url).build();
        final Call call = this.mClient.newCall(request);
        new AsyncTask<Void, Void, List<Story>>() {

            @Override
            protected List<Story> doInBackground(Void... params) {
                try {
                    Response response = call.execute();
                    return parseStoryList(response);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<Story> storyList) {
                if (storyList == null || storyList.size() == 0) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onStoriesLoaded(storyList);
                }
            }
        }.execute();
    }

    public void getStory(int storyId, @NonNull final StoriesDataSource.GetStoryCallback callback) {
        String url = BASE_URL + storyId;
        Request request = new Request.Builder().url(url).build();
        final Call call = this.mClient.newCall(request);
        new AsyncTask<Void, Void, Story>() {

            @Override
            protected Story doInBackground(Void... params) {
                try {
                    Response response = call.execute();
                    return parseStory(response);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Story story) {
                if (story == null) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onStoryLoaded(story);
                }
            }
        }.execute();
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
