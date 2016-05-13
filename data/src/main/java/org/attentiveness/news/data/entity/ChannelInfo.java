package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Channel Info
 */
public class ChannelInfo {

    @SerializedName("ret_code")
    private int code;

    @SerializedName("totalNum")
    private int channelNum;

    @SerializedName("channelList")
    private List<ChannelEntity> channelEntityList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(int channelNum) {
        this.channelNum = channelNum;
    }

    public List<ChannelEntity> getChannelEntityList() {
        return channelEntityList;
    }

    public void setChannelEntityList(List<ChannelEntity> channelEntityList) {
        this.channelEntityList = channelEntityList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** Channel Info **********").append("\n");
        stringBuilder.append("code = ").append(this.getCode()).append("\n");
        stringBuilder.append("channel number = ").append(this.getChannelNum()).append("\n");
        stringBuilder.append("channel list = ").append(this.getChannelEntityList()).append("\n");
        stringBuilder.append("********** Channel Info **********").append("\n");
        return stringBuilder.toString();
    }
}
