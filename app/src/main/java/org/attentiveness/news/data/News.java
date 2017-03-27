package org.attentiveness.news.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("date")
    private String date;

    @SerializedName("stories")
    private List<Story> storyList;

    @SerializedName("top_stories")
    private List<Story> topStoryList;

    public News() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public List<Story> getTopStoryList() {
        return topStoryList;
    }

    public void setTopStoryList(List<Story> topStoryList) {
        this.topStoryList = topStoryList;
    }

}
