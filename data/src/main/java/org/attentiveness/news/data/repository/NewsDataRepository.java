package org.attentiveness.news.data.repository;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.mapper.NewsEntityDataMapper;
import org.attentiveness.news.data.repository.datasource.NewsDataStore;
import org.attentiveness.news.data.repository.datasource.NewsDataStoreFactory;
import org.attentiveness.news.domain.bean.Channel;
import org.attentiveness.news.domain.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * News Data Repository
 */
@Singleton
public class NewsDataRepository implements NewsRepository {

    private NewsDataStoreFactory mNewsDataStoreFactory;
    private NewsEntityDataMapper mNewsEntityDataMapper;

    @Inject
    public NewsDataRepository(NewsDataStoreFactory newsDataStoreFactory, NewsEntityDataMapper newsEntityDataMapper) {
        this.mNewsDataStoreFactory = newsDataStoreFactory;
        this.mNewsEntityDataMapper = newsEntityDataMapper;
    }

    @Override
    public Observable<List<Channel>> getChannelList() {
        NewsDataStore newsDataStore = mNewsDataStoreFactory.createCloudDataStore();
        return newsDataStore.getNewsEntityList().map(new Func1<List<ChannelEntity>, List<Channel>>() {
            @Override
            public List<Channel> call(List<ChannelEntity> channelEntityList) {
                return mNewsEntityDataMapper.transform(channelEntityList);
            }
        });
    }
}
