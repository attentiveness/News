package org.attentiveness.news.data.source;


import org.attentiveness.news.data.Channel;

import java.util.List;

import rx.Observable;

public interface ChannelDataSource {

    Observable<List<Channel.Detail>> getChannelList();

    Observable<Channel.Detail> getChannel(int channelId);

    void saveChannel(Channel.Detail channel);

    void deleteChannel(String channelId, String name);

    void deleteAllChannels();

    void refreshChannelList();

}
