package org.attentiveness.news.data.source;


import org.attentiveness.news.data.Channel;

import java.util.List;

import rx.Observable;

public interface ChannelDataSource {

    Observable<List<Channel>> getChannelList();

    Observable<Channel> getChannel(int channelId);

    void saveChannel(Channel channel);

    void deleteChannel(String channelId, String name);

    void deleteAllChannels();

    void refreshChannelList();
}
