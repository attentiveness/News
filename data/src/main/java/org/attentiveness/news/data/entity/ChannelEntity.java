package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Channel Entity
 */
public class ChannelEntity {

//    @SerializedName("channelId")
    private String id;

//    @SerializedName("name")
    private String name;

    public ChannelEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** Channel Entity **********").append("\n");
        stringBuilder.append("id = ").append(this.getId()).append("\n");
        stringBuilder.append("name = ").append(this.getName()).append("\n");
        stringBuilder.append("********** Channel Entity **********").append("\n");
        return stringBuilder.toString();
    }
}
