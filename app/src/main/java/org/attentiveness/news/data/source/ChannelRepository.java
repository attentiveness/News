package org.attentiveness.news.data.source;


import android.content.Context;

import org.attentiveness.news.data.Channel;

import java.util.List;

import rx.Observable;

public class ChannelRepository implements ChannelDataSource {

    private static NewsRepository INSTANCE = null;

    private ChannelRepository(Context context) {

    }

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
