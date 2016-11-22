package org.attentiveness.news.data.source;


import android.content.Context;

import org.attentiveness.news.data.Channel;
import org.attentiveness.news.data.source.local.ChannelLocalDataSource;
import org.attentiveness.news.data.source.remote.ChannelRemoteDataSource;
import org.attentiveness.news.net.RestApi;

import java.util.List;

import rx.Observable;

public class ChannelRepository implements ChannelDataSource {

    private static ChannelRepository INSTANCE = null;

    private RestApi mRestApi;
    private ChannelLocalDataSource mLocalData;
    private ChannelRemoteDataSource mRemoteData;

    private ChannelRepository(Context context) {
        mLocalData = ChannelLocalDataSource.getInstance(context);
        mRemoteData = ChannelRemoteDataSource.getInstance();
        mRestApi = RestApi.getInstance();
    }

    public static ChannelRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ChannelRepository(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Channel>> getChannelList() {
        return mRestApi.getChannelList();
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
