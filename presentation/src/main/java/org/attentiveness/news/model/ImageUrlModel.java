package org.attentiveness.news.model;

/**
 * Image Url Model
 */
public class ImageUrlModel {

    private int width;
    private int height;
    private String url;

    public ImageUrlModel() {
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
