package org.attentiveness.news.data.net;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.NewsEntity;

import java.util.List;

import rx.Observable;

/**
 * Rest Api Interface
 */
public interface RestApi {

    String API_BASE_URL = "http://apis.baidu.com/showapi_open_bus/channel_news/";

    Observable<List<ChannelEntity>> getChannelEntityList();

    Observable<List<NewsEntity>> getNewsEntityList();
}
