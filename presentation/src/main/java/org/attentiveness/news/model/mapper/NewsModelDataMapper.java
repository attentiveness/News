package org.attentiveness.news.model.mapper;

import org.attentiveness.news.domain.bean.Channel;
import org.attentiveness.news.domain.bean.ImageUrl;
import org.attentiveness.news.domain.bean.News;
import org.attentiveness.news.internal.di.PerActivity;
import org.attentiveness.news.model.ChannelModel;
import org.attentiveness.news.model.ImageUrlModel;
import org.attentiveness.news.model.NewsModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * News Model Data Mapper
 */
@PerActivity
public class NewsModelDataMapper {

    @Inject
    public NewsModelDataMapper() {
    }

    public ChannelModel transform(Channel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Cannot transform null value.");
        }
        ChannelModel channelModel = new ChannelModel(channel.getId());
        channelModel.setName(channel.getName());
        return channelModel;
    }

    public Collection<ChannelModel> transform(List<Channel> channelList) {
        Collection<ChannelModel> channelModelCollection = new ArrayList<>();
        if (channelList != null && !channelList.isEmpty()) {
            for (Channel channel : channelList) {
                channelModelCollection.add(transform(channel));
            }
        }
        return channelModelCollection;
    }

    public ImageUrlModel transform(ImageUrl imageUrl) {
        if (imageUrl == null) {
            return null;
        }
        ImageUrlModel imageUrlModel = new ImageUrlModel();
        imageUrlModel.setWidth(imageUrl.getWidth());
        imageUrlModel.setHeight(imageUrl.getHeight());
        imageUrlModel.setUrl(imageUrl.getUrl());
        return imageUrlModel;
    }

    public ImageUrlModel[] transform(ImageUrl[] imageUrls) {
        if (imageUrls == null || imageUrls.length == 0) {
            return null;
        }
        ImageUrlModel[] imageUrlModels = new ImageUrlModel[imageUrls.length];
        int i = 0;
        for (ImageUrl imageUrl : imageUrls) {
            imageUrlModels[i++] = transform(imageUrl);
        }
        return imageUrlModels;
    }

    public NewsModel transform(News news) {
        if (news == null) {
            throw new IllegalArgumentException("Cannot transform null value.");
        }
        NewsModel newsModel = new NewsModel(news.getId());
        newsModel.setChannelId(news.getChannelId());
        newsModel.setChannelName(news.getChannelName());
        newsModel.setTitle(news.getTitle());
        newsModel.setDesc(news.getDesc());
        newsModel.setImgUrls(transform(news.getImgUrls()));
        newsModel.setSource(news.getSource());
        newsModel.setPubDate(news.getPubDate());
        newsModel.setLink(news.getLink());
        newsModel.setContent(news.getContent());
        newsModel.setHtml(news.getHtml());
        return newsModel;
    }

    public Collection<NewsModel> transform(Collection<News> newsCollection) {
        Collection<NewsModel> newsModelCollection = new ArrayList<>();
        if (newsCollection != null && !newsCollection.isEmpty()) {
            for (News news : newsCollection) {
                newsModelCollection.add(transform(news));
            }
        }
        return newsModelCollection;
    }

}
