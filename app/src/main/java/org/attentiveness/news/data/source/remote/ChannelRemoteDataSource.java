package org.attentiveness.news.data.source.remote;


import org.attentiveness.news.data.Channel;
import org.attentiveness.news.data.source.ChannelDataSource;

import java.util.List;

import rx.Observable;

public class ChannelRemoteDataSource implements ChannelDataSource{
    @Override
    public Observable<List<Channel.Detail>> getChannelList() {
        return null;
    }

    @Override
    public Observable<Channel.Detail> getChannel(int channelId) {
        return null;
    }

    @Override
    public void saveChannel(Channel.Detail channel) {

    }

    @Override
    public void deleteChannel(String channelId, String name) {

    }

    @Override
    public void deleteAllChannels() {

    }

    @Override
    public void refreshChannelList() {

    }
}
