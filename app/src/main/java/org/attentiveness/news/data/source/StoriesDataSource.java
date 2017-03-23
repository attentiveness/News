package org.attentiveness.news.data.source;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;

import java.util.List;

public interface StoriesDataSource {

    interface LoadStoriesCallback {

        void onStoriesLoaded(List<Story> stories);

        void onDataNotAvailable();
    }

    interface GetStoryCallback {

        void onStoryLoaded(Story story);

        void onDataNotAvailable();
    }

    void getStories(@NonNull LoadStoriesCallback callback);

    void getStory(@NonNull int storyId, @NonNull GetStoryCallback callback);

    void saveStory(@NonNull Story story);

    void refreshStories();

    void deleteAllStories();

    void deleteStory(@NonNull int storyId);
}
