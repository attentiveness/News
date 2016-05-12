package org.attentiveness.news.model;

import java.util.Date;

/**
 * News Model
 */
public class NewsModel {

    private String id;
    private String title;
    private String desc;
    private String content;
    private String html;
    private String link;
    private String[] imgUrls;
    private Date pubDate;
    private String source;

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** News Model **********").append("\n");
        stringBuilder.append("********** News Model **********").append("\n");
        return stringBuilder.toString();
    }
}
