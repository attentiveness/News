package org.attentiveness.news.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;
import org.attentiveness.news.data.source.StoriesDataSource;
import org.attentiveness.news.util.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.Observable;

public class LocalStoriesDataSource implements StoriesDataSource {

    private static LocalStoriesDataSource INSTANCE;

    private StoriesDbHelper mDbHelper;

    // Prevent direct instantiation.
    private LocalStoriesDataSource(@NonNull Context context,
                                   @NonNull BaseSchedulerProvider schedulerProvider) {
        this.mDbHelper = new StoriesDbHelper(context);
    }

    public static LocalStoriesDataSource getInstance(@NonNull Context context,
                                                     @NonNull BaseSchedulerProvider schedulerProvider) {
        if (INSTANCE == null) {
            INSTANCE = new LocalStoriesDataSource(context, schedulerProvider);
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
