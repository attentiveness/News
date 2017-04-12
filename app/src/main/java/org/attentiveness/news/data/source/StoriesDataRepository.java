package org.attentiveness.news.data.source;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

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
        this.mStoriesRemoteDataSource = storiesRemoteDataSource;
        this.mStoriesLocalDataSource = storiesLocalDataSource;
        this.mCachedStories = new HashMap<>();
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
        if (this.mCachedStories != null && !this.mCacheIsDirty) {
            List<Story> storyList = (List<Story>) this.mCachedStories.values();
            return Observable.just(storyList);
        }
        Observable<List<Story>> remoteStoryList = this.getAndSaveStoryListFromRemote(date);
        if (this.mCacheIsDirty) {
            return remoteStoryList;
        } else {
            Observable<List<Story>> localStoryList = this.getAndSaveStoryListFromLocal(date);
            return Observable.concat(localStoryList, remoteStoryList)
                    .filter(new Predicate<List<Story>>() {
                        @Override
                        public boolean test(@io.reactivex.annotations.NonNull List<Story> storyList) throws Exception {
                            return storyList != null && storyList.size() > 0;
                        }
                    })
                    .firstElement()
                    .toObservable();
        }
    }

    /**
     * Get story detail. Now it just gets data from remote source, not from local source and not
     * cache the story detail.
     *
     * @param storyId Each story has one unique id.
     * @return Observable wraps story detail.
     */
    @Override
    public Observable<StoryDetail> getStoryDetail(int storyId) {
        return this.mStoriesRemoteDataSource.getStoryDetail(storyId);
    }

    @Override
    public void saveStories(@NonNull List<Story> storyList) {
        this.mStoriesLocalDataSource.saveStories(storyList);
        this.mStoriesRemoteDataSource.saveStories(storyList);
        if (this.mCachedStories == null) {
            this.mCachedStories = new HashMap<>();
        }
        for (Story story : storyList) {
            this.mCachedStories.put(story.getId(), story);
        }
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

    private Observable<List<Story>> getAndSaveStoryListFromRemote(String date) {
        return this.mStoriesRemoteDataSource.getStories(date)
                .doOnNext(new Consumer<List<Story>>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull List<Story> storyList) throws Exception {
                        mStoriesLocalDataSource.saveStories(storyList);
                        for (Story story : storyList) {
                            mCachedStories.put(story.getId(), story);
                        }
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        mCacheIsDirty = true;
                    }
                });
    }

    private Observable<List<Story>> getAndSaveStoryListFromLocal(String date) {
        return this.mStoriesLocalDataSource.getStories(date).doOnNext(new Consumer<List<Story>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<Story> storyList) throws Exception {
                for (Story story : storyList) {
                    mCachedStories.put(story.getId(), story);
                }
            }
        });
    }

}
