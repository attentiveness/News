package org.attentiveness.news.data.source.remote;


import org.attentiveness.news.data.Channel;
import org.attentiveness.news.data.source.ChannelDataSource;

import java.util.List;

import rx.Observable;

public class ChannelRemoteDataSource implements ChannelDataSource {

    private static ChannelRemoteDataSource INSTANCE;

    private ChannelRemoteDataSource() {

    }

    public static ChannelRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChannelRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Channel>> getChannelList() {
        return null;
    }

    @Override
    public Observable<Channel> getChannel(int channelId) {
        return null;
    }

    @Override
    public void saveChannel(Channel channel) {

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
