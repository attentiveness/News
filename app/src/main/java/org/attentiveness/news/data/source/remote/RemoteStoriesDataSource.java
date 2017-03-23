package org.attentiveness.news.data.source.remote;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;

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

    }

    @Override
    public void getStory(int storyId, @NonNull GetStoryCallback callback) {

    }

    @Override
    public void saveStory(@NonNull Story story) {

    }

    @Override
    public void refreshStories() {

    }

    @Override
    public void deleteAllStories() {

    }

    @Override
    public void deleteStory(int storyId) {

    }
}
