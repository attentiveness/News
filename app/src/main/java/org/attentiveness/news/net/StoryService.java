package org.attentiveness.news.net;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.StoryDetail;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoryService {

    @GET("before/{date}")
    Observable<List<Story>> getStoryList(@Path("date") String date);

    @GET("{id}")
    Observable<StoryDetail> getStoryDetail(@Path("id") int storyId);

}
