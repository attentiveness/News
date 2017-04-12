package org.attentiveness.news.data.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;
import org.attentiveness.news.data.source.StoriesDataSource;
import org.attentiveness.news.net.HttpManager;

import java.util.List;

import io.reactivex.Observable;

public class RemoteStoriesDataSource implements StoriesDataSource {

    private static RemoteStoriesDataSource INSTANCE;

    private Context mContext;

    public static RemoteStoriesDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteStoriesDataSource(context);
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private RemoteStoriesDataSource(Context context) {
        this.mContext = context;
    }

    @Override
    public Observable<List<Story>> getStories(String date) {
        return HttpManager.getInstance(this.mContext).getStoryList(date);
    }

    @Override
    public Observable<StoryDetail> getStoryDetail(int storyId) {
        return HttpManager.getInstance(this.mContext).getStory(storyId);
    }

    @Override
    public void saveStories(@NonNull List<Story> storyList) {
        //do nothing
    }

    @Override
    public void refreshStories() {
        // do nothing
    }

    @Override
    public void deleteAllStories() {
        // do nothing
    }

}
