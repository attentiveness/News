package org.attentiveness.news.data.repository.datasource;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.net.RestApi;

import java.util.List;

import rx.Observable;

/**
 * Cloud News Data Store
 */
public class CloudNewsDataStore implements NewsDataStore {

    private RestApi mRestApi;

    public CloudNewsDataStore(RestApi restApi) {
        this.mRestApi = restApi;
    }

    @Override
    public Observable<List<ChannelEntity>> getNewsEntityList() {
        return mRestApi.getChannelList();
    }
}
