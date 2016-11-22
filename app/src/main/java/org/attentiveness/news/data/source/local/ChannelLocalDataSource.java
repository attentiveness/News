package org.attentiveness.news.data.source.local;


import android.content.Context;

import org.attentiveness.news.data.Channel;
import org.attentiveness.news.data.source.ChannelDataSource;

import java.util.List;

import rx.Observable;

public class ChannelLocalDataSource implements ChannelDataSource {

    private static ChannelLocalDataSource INSTANCE;

    private ChannelLocalDataSource(Context context) {

    }

    public static ChannelLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ChannelLocalDataSource(context);
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
