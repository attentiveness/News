package org.attentiveness.news.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;

public class LocalStoriesDataSource implements StoriesDataSource {

    private static LocalStoriesDataSource INSTANCE;

    private StoriesDbHelper mDbHelper;

    // Prevent direct instantiation.
    private LocalStoriesDataSource(@NonNull Context context) {
        mDbHelper = new StoriesDbHelper(context);
    }

    public static LocalStoriesDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocalStoriesDataSource(context);
        }
        return INSTANCE;
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
