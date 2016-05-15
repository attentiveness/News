package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Page Entity
 */
public class PageEntity {

    @SerializedName("allNum")
    private int totalNewsNum;

    @SerializedName("allPages")
    private int totalPagesNum;

    @SerializedName("currentPage")
    private int currentPageNum;

    @SerializedName("maxResult")
    private int maxNewsNumInPage;

    @SerializedName("contentlist")
    private List<NewsEntity> newsEntityList;

    public PageEntity() {
        //empty
    }

    public int getTotalNewsNum() {
        return totalNewsNum;
    }

    public void setTotalNewsNum(int totalNewsNum) {
        this.totalNewsNum = totalNewsNum;
    }

    public int getTotalPagesNum() {
        return totalPagesNum;
    }

    public void setTotalPagesNum(int totalPagesNum) {
        this.totalPagesNum = totalPagesNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getMaxNewsNumInPage() {
        return maxNewsNumInPage;
    }

    public void setMaxNewsNumInPage(int maxNewsNumInPage) {
        this.maxNewsNumInPage = maxNewsNumInPage;
    }

    public List<NewsEntity> getNewsEntityList() {
        return newsEntityList;
    }

    public void setNewsEntityList(List<NewsEntity> newsEntityList) {
        this.newsEntityList = newsEntityList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** Page Entity **********").append("\n");
        stringBuilder.append("total news number = ").append(this.getTotalNewsNum()).append("\n");
        stringBuilder.append("total page number = ").append(this.getTotalPagesNum()).append("\n");
        stringBuilder.append("current page number = ").append(this.getCurrentPageNum()).append("\n");
        stringBuilder.append("max news number in one page = ").append(this.getMaxNewsNumInPage()).append("\n");
        stringBuilder.append("news entity list = ").append(this.getNewsEntityList()).append("\n");
        stringBuilder.append("********** Page Entity **********").append("\n");
        return stringBuilder.toString();
    }
}
