package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * News Entity
 */
public class NewsEntity {

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

    @SerializedName("imgageurls")
    private ImageUrlEntity[] imgUrls;

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

    public NewsEntity(String id) {
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

    public ImageUrlEntity[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ImageUrlEntity[] imgUrls) {
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
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** News Entity **********").append("\n");
        stringBuilder.append("id = ").append(this.getId()).append("\n");
        stringBuilder.append("channel id = ").append(this.getChannelId()).append("\n");
        stringBuilder.append("channel name = ").append(this.getChannelName()).append("\n");
        stringBuilder.append("title = ").append(this.getTitle()).append("\n");
        stringBuilder.append("description = ").append(this.getDesc()).append("\n");
        stringBuilder.append("image number = ").append(this.getImgUrls().length).append("\n");
        stringBuilder.append("source = ").append(this.getSource()).append("\n");
        stringBuilder.append("public date = ").append(this.getPubDate()).append("\n");
        stringBuilder.append("link = ").append(this.getLink()).append("\n");
        stringBuilder.append("content = ").append(this.getContent()).append("\n");
        stringBuilder.append("html = ").append(this.getHtml()).append("\n");
        stringBuilder.append("********** News Entity **********").append("\n");
        return stringBuilder.toString();
    }

}
