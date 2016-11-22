package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelPage {

    @SerializedName("channelList")
    private List<Channel> channelList;

    @SerializedName("ret_code")
    private int resultCode;

    @SerializedName("totalNum")
    private int totalNum;

    public ChannelPage() {

    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "ChannelPage{" +
                "channelList=" + channelList +
                ", resultCode=" + resultCode +
                ", totalNum=" + totalNum +
                '}';
    }
}
