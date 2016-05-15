package org.attentiveness.news.data.entity.mapper;

import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.domain.bean.Channel;

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

}
