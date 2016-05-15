package org.attentiveness.news.model.mapper;

import org.attentiveness.news.domain.bean.Channel;
import org.attentiveness.news.internal.di.PerActivity;
import org.attentiveness.news.model.ChannelModel;

import java.util.ArrayList;
import java.util.Collection;

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

    public Collection<ChannelModel> transform(Collection<Channel> channelCollection) {
        Collection<ChannelModel> channelModelCollection = new ArrayList<>();
        if (channelCollection != null && !channelCollection.isEmpty()) {
            for (Channel channel : channelCollection) {
                channelModelCollection.add(transform(channel));
            }
        }
        return channelModelCollection;
    }

}
