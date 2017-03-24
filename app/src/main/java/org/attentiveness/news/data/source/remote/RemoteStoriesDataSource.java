package org.attentiveness.news.data.source.remote;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;
import org.attentiveness.news.net.HttpManager;

import java.util.List;

public class RemoteStoriesDataSource implements StoriesDataSource {

    private static RemoteStoriesDataSource INSTANCE;

    public static RemoteStoriesDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteStoriesDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private RemoteStoriesDataSource() {
    }

    @Override
    public void getStories(@NonNull LoadStoriesCallback callback) {
        List<Story> storyList = HttpManager.getInstance().getStoryList();
        if (storyList == null || storyList.size() == 0) {
            callback.onDataNotAvailable();
        } else {
            callback.onStoriesLoaded(storyList);
        }
    }

    @Override
    public void getStory(int storyId, @NonNull GetStoryCallback callback) {
        Story story = HttpManager.getInstance().getStory(storyId);
        if (story == null) {
            callback.onDataNotAvailable();
        } else {
            callback.onStoryLoaded(story);
        }
    }

    @Override
    public void saveStory(@NonNull Story story) {
        // do nothing
    }

    @Override
    public void refreshStories() {
        // do nothing
    }

    @Override
    public void deleteAllStories() {
        // do nothing
    }

    @Override
    public void deleteStory(int storyId) {
        // do nothing
    }
}
