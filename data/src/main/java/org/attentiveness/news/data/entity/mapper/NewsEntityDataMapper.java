package org.attentiveness.news.data.entity.mapper;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.entity.ImageUrlEntity;
import org.attentiveness.news.data.entity.NewsEntity;
import org.attentiveness.news.domain.bean.Channel;
import org.attentiveness.news.domain.bean.ImageUrl;
import org.attentiveness.news.domain.bean.News;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * News Entity Data Mapper
 */
@Singleton
public class NewsEntityDataMapper {

    @Inject
    public NewsEntityDataMapper() {

    }

    public Channel transform(ChannelEntity channelEntity) {
        Channel channel = null;
        if (channelEntity != null) {
            channel = new Channel(channelEntity.getId());
            channel.setName(channelEntity.getName());
        }
        return channel;
    }

    public List<Channel> transform(Collection<ChannelEntity> channelEntityCollection) {
        List<Channel> channelList = new ArrayList<>(20);
        Channel channel;
        if (channelEntityCollection != null) {
            for (ChannelEntity channelEntity : channelEntityCollection) {
                channel = transform(channelEntity);
                if (channel != null) {
                    channelList.add(channel);
                }
            }
        }
        return channelList;
    }

    public ImageUrl transform(ImageUrlEntity imageUrlEntity) {
        ImageUrl imageUrl = null;
        if (imageUrlEntity != null) {
            imageUrl = new ImageUrl();
            imageUrl.setWidth(imageUrlEntity.getWidth());
            imageUrl.setHeight(imageUrlEntity.getHeight());
            imageUrl.setUrl(imageUrlEntity.getUrl());
        }
        return imageUrl;
    }

    public ImageUrl[] transform(ImageUrlEntity[] imageUrlEntities) {
        ImageUrl[] imageUrls = null;
        if (imageUrlEntities != null) {
            imageUrls = new ImageUrl[imageUrlEntities.length];
            for (int i = 0; i < imageUrlEntities.length; i++) {
                imageUrls[i] = transform(imageUrlEntities[i]);
            }
        }
        return imageUrls;
    }

    public News transform(NewsEntity newsEntity) {
        News news = null;
        if (newsEntity != null) {
            news = new News(newsEntity.getId());
            news.setChannelId(newsEntity.getChannelId());
            news.setChannelName(newsEntity.getChannelName());
            news.setTitle(newsEntity.getTitle());
            news.setDesc(newsEntity.getDesc());
            news.setImgUrls(transform(newsEntity.getImgUrls()));
            news.setSource(newsEntity.getSource());
            news.setPubDate(newsEntity.getPubDate());
            news.setLink(newsEntity.getLink());
            news.setContent(newsEntity.getContent());
            news.setHtml(newsEntity.getHtml());
        }
        return news;
    }

    public List<News> transform(List<NewsEntity> newsEntityList) {
        List<News> newsList = new ArrayList<>();
        if (newsEntityList != null && !newsEntityList.isEmpty()) {
            for (NewsEntity entity : newsEntityList) {
                newsList.add(transform(entity));
            }
        }
        return newsList;
    }

}
