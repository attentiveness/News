package org.attentiveness.news.data.source;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getStories(@NonNull final LoadStoriesCallback callback) {
        if (this.mCachedStories != null && !this.mCacheIsDirty) {
            callback.onStoriesLoaded(new ArrayList<>(this.mCachedStories.values()));
            return;
        }
        if (this.mCacheIsDirty) {
            this.getRemoteDataSource(callback);
        } else {
            mStoriesLocalDataSource.getStories(new LoadStoriesCallback() {
                @Override
                public void onStoriesLoaded(List<Story> stories) {
                    refreshCache(stories);
                    callback.onStoriesLoaded(new ArrayList<>(mCachedStories.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    getRemoteDataSource(callback);
                }
            });
        }
    }

    @Override
    public void getStory(final int storyId, @NonNull final GetStoryCallback callback) {
        Story story = getStoryById(storyId);
        if (story != null) {
            callback.onStoryLoaded(story);
            return;
        }
        this.mStoriesLocalDataSource.getStory(storyId, new GetStoryCallback() {
            @SuppressLint("UseSparseArrays")
            @Override
            public void onStoryLoaded(Story story) {
                if (mCachedStories == null) {
                    mCachedStories = new HashMap<>();
                }
                mCachedStories.put(story.getId(), story);
                callback.onStoryLoaded(story);
            }

            @Override
            public void onDataNotAvailable() {
                mStoriesRemoteDataSource.getStory(storyId, new GetStoryCallback() {

                    @SuppressLint("UseSparseArrays")
                    @Override
                    public void onStoryLoaded(Story story) {
                        if (mCachedStories == null) {
                            mCachedStories = new HashMap<>();
                        }
                        mCachedStories.put(story.getId(), story);
                        callback.onStoryLoaded(story);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveStory(@NonNull Story story) {
        this.mStoriesLocalDataSource.saveStory(story);
        this.mStoriesRemoteDataSource.saveStory(story);
        if (this.mCachedStories == null) {
            this.mCachedStories = new HashMap<>();
        }
        this.mCachedStories.put(story.getId(), story);
    }

    @Override
    public void refreshStories() {
        this.mCacheIsDirty = true;
    }

    @Override
    public void deleteAllStories() {
        this.mStoriesLocalDataSource.deleteAllStories();
        this.mStoriesRemoteDataSource.deleteAllStories();
        if (this.mCachedStories == null) {
            this.mCachedStories = new HashMap<>();
        }
        this.mCachedStories.clear();
    }

    @Override
    public void deleteStory(int storyId) {
        this.mStoriesLocalDataSource.deleteStory(storyId);
        this.mStoriesRemoteDataSource.deleteStory(storyId);
        if (this.mCachedStories == null) {
            this.mCachedStories = new HashMap<>();
        }
        this.mCachedStories.remove(storyId);
    }

    private void getRemoteDataSource(final LoadStoriesCallback callback) {
        this.mStoriesRemoteDataSource.getStories(new LoadStoriesCallback() {
            @Override
            public void onStoriesLoaded(List<Story> stories) {
                refreshLocalDataSource(stories);
                refreshCache(stories);
                callback.onStoriesLoaded(stories);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    private void refreshLocalDataSource(List<Story> stories) {
        this.mStoriesLocalDataSource.deleteAllStories();
        if (stories != null && stories.size() > 0) {
            for (Story story : stories) {
                this.mStoriesLocalDataSource.saveStory(story);
            }
        }
    }

    @SuppressLint("UseSparseArrays")
    private void refreshCache(List<Story> stories) {
        if (this.mCachedStories == null) {
            this.mCachedStories = new HashMap<>();
        }
        this.mCachedStories.clear();
        if (stories != null && stories.size() > 0) {
            for (Story story : stories) {
                this.mCachedStories.put(story.getId(), story);
            }
        }
        this.mCacheIsDirty = false;
    }

    private Story getStoryById(int storyId) {
        if (this.mCachedStories == null || this.mCachedStories.isEmpty()) {
            return null;
        } else {
            return this.mCachedStories.get(storyId);
        }
    }

}
