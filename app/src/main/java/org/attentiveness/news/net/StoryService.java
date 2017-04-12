package org.attentiveness.news.net;

import org.attentiveness.news.data.News;
import org.attentiveness.news.data.StoryDetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoryService {

    @GET("before/{date}")
    Observable<News> getStoryList(@Path("date") String date);

    @GET("{id}")
    Observable<StoryDetail> getStoryDetail(@Path("id") int storyId);

}
