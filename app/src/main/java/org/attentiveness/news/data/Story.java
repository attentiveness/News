package org.attentiveness.news.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Story {

    private int id;
    private String title;

    @SerializedName("images")
    private List<String> imageList;

    public Story() {

    }

    public Story(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
