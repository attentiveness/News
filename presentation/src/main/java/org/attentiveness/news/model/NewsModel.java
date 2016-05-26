package org.attentiveness.news.model;


/**
 * News Model
 */
public class NewsModel {

    private String channelId;
    private String channelName;
    private String id;
    private String title;
    private String desc;
    private ImageUrlModel[] imgUrls;
    private String source;
    private String pubDate;
    private String link;
    private String content;
    private String html;

    public NewsModel(String id) {
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

    public ImageUrlModel[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ImageUrlModel[] imgUrls) {
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
        stringBuilder.append("********** News Model **********").append("\n");
        stringBuilder.append("id = ").append(this.getId()).append("\n");
        stringBuilder.append("channel id = ").append(this.getChannelId()).append("\n");
        stringBuilder.append("channel name = ").append(this.getChannelName()).append("\n");
        stringBuilder.append("title = ").append(this.getTitle()).append("\n");
        stringBuilder.append("description = ").append(this.getDesc()).append("\n");
        stringBuilder.append("image number = ").append(this.getImgUrls() == null ? 0 : this.getImgUrls().length).append("\n");
        stringBuilder.append("source = ").append(this.getSource()).append("\n");
        stringBuilder.append("public date = ").append(this.getPubDate()).append("\n");
        stringBuilder.append("link = ").append(this.getLink()).append("\n");
        stringBuilder.append("content = ").append(this.getContent()).append("\n");
        stringBuilder.append("html = ").append(this.getHtml()).append("\n");
        stringBuilder.append("********** News Model **********").append("\n");
        return stringBuilder.toString();
    }

}
