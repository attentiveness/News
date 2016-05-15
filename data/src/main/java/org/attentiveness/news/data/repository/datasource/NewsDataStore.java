package org.attentiveness.news.data.repository.datasource;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.NewsEntity;

import java.util.List;

import rx.Observable;

/**
 * News Data Store
 */
public interface NewsDataStore {

    Observable<List<ChannelEntity>> getChannelEntityList();

    Observable<List<NewsEntity>> getNewsEntityList();
}
