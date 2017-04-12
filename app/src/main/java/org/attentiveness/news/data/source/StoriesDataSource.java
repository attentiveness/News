package org.attentiveness.news.data.source;

import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;

import java.util.List;

import io.reactivex.Observable;

public interface StoriesDataSource {

    Observable<List<Story>> getStories(String date);

    Observable<StoryDetail> getStoryDetail(int storyId);

    void saveStories(@NonNull List<Story> storyList);

    void refreshStories();

    void deleteAllStories();

}
