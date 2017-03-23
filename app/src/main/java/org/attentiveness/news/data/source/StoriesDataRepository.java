package org.attentiveness.news.data.source;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;

import java.util.Map;

public class StoriesDataRepository implements StoriesDataSource {

    private static StoriesDataRepository INSTANCE = null;

    private final StoriesDataSource mStoriesRemoteDataSource;

    private final StoriesDataSource mStoriesLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, Story> mCachedStories;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private StoriesDataRepository(@NonNull StoriesDataSource storiesRemoteDataSource,
                                  @NonNull StoriesDataSource storiesLocalDataSource) {
        mStoriesRemoteDataSource = storiesRemoteDataSource;
        mStoriesLocalDataSource = storiesLocalDataSource;
    }

    public static StoriesDataRepository getInstance(StoriesDataSource storiesRemoteDataSource,
                                                    StoriesDataSource storiesLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new StoriesDataRepository(storiesRemoteDataSource, storiesLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getStories(@NonNull LoadStoriesCallback callback) {

    }

    @Override
    public void getStory(@NonNull int storyId, @NonNull GetStoryCallback callback) {

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
    public void deleteStory(@NonNull int storyId) {

    }
}
