package org.attentiveness.news.data.source;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public class StoriesDataRepository implements StoriesDataSource {

    private static StoriesDataRepository INSTANCE = null;

    private final StoriesDataSource mStoriesRemoteDataSource;

    private final StoriesDataSource mStoriesLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    private Map<Integer, Story> mCachedStories;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    private boolean mCacheIsDirty = false;

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
    public Observable<List<Story>> getStories(String date) {
        return null;
    }

    @Override
    public Observable<StoryDetail> getStory(int storyId) {
        return null;
    }

    @Override
    public void saveStories(@NonNull List<Story> storyList) {

    }

    @Override
    public void refreshStories() {

    }

    @Override
    public void deleteAllStories() {

    }
}
