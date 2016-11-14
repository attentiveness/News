package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Channel {

    @SerializedName("channelList")
    private List<Detail> detailList;

    @SerializedName("ret_code")
    private int resultCode;

    @SerializedName("totalNum")
    private int totalNum;

    public Channel() {

    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
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
        return "Channel{" +
                "detailList=" + detailList +
                ", resultCode=" + resultCode +
                ", totalNum=" + totalNum +
                '}';
    }

    public class Detail {

        @SerializedName("channelId")
        private String channelId;

        @SerializedName("name")
        private String name;

        public Detail(String channelId, String name) {
            this.channelId = channelId;
            this.name = name;
        }

        public String getChannelId() {
            return channelId;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "channelId='" + channelId + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
