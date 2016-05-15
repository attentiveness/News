package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Page Info
 */
public class PageInfo {

    @SerializedName("pagebean")
    private PageEntity pageEntity;

    @SerializedName("ret_code")
    private int code;

    public PageInfo() {
        //empty
    }

    public PageEntity getPageEntity() {
        return pageEntity;
    }

    public void setPageEntity(PageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** Page Info **********").append("\n");
        stringBuilder.append("page bean = ").append(this.getPageEntity()).append("\n");
        stringBuilder.append("result code = ").append(this.getCode()).append("\n");
        stringBuilder.append("********** Page Info **********").append("\n");
        return stringBuilder.toString();
    }
}
