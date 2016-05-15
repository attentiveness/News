package org.attentiveness.news.domain.repository;

import org.attentiveness.news.domain.bean.Channel;

import java.util.List;

import rx.Observable;

/**
 * News Repository
 */
public interface NewsRepository {

    Observable<List<Channel>> getChannelList();
}
