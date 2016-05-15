package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Image Url Entity
 */
public class ImageUrlEntity {

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("url")
    private String url;

    public ImageUrlEntity() {
        //empty
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "width = " + this.getWidth() + ", height = " + this.getHeight() + ", url = " + this.getUrl();
    }
}
