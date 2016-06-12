package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class News {

    @SerializedName("nid")
    private String id;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String desc;

    @SerializedName("imageurls")
    private ImageUrl[] imgUrls;

    @SerializedName("source")
    private String source;

    @SerializedName("pubDate")
    private String pubDate;

    @SerializedName("link")
    private String link;

    @SerializedName("content")
    private String content;

    @SerializedName("html")
    private String html;

    public News() {
        //empty
    }

    public News(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ImageUrl[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ImageUrl[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", channelName=" + channelName +
                ", title=" + title +
                ", desc=" + desc +
                ", imgUrls=" + Arrays.toString(imgUrls) +
                ", source=" + source +
                ", pubDate=" + pubDate +
                ", link=" + link +
                ", content=" + content +
                ", html=" + html +
                "}";
    }

    public class ImageUrl {

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;

        @SerializedName("url")
        private String url;

        public ImageUrl() {
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
            return "ImageUrl{" +
                    "width=" + width +
                    ", height=" + height +
                    ", url='" + url + "'" +
                    "}";
        }
    }

}
