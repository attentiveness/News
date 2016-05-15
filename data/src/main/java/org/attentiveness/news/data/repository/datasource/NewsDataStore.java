package org.attentiveness.news.data.repository.datasource;

import org.attentiveness.news.data.entity.ChannelEntity;

import java.util.List;

import rx.Observable;

/**
 * News Data Store
 */
public interface NewsDataStore {

    Observable<List<ChannelEntity>> getNewsEntityList();
}
