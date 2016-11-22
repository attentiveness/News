package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

public class Channel {

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("name")
    private String name;

    public Channel(String channelId, String name) {
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
        return "Channel{" +
                "channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
