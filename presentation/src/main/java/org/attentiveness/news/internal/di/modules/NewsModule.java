package org.attentiveness.news.internal.di.modules;

import org.attentiveness.news.domain.interactor.GetChannelList;
import org.attentiveness.news.domain.interactor.UseCase;
import org.attentiveness.news.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * News Module
 */
@Module
public class NewsModule {

    public NewsModule() {

    }

    @Provides
    @PerActivity
    @Named("channelList")
    UseCase provideGetChannelListUseCase(GetChannelList getChannelListUseCase) {
        return getChannelListUseCase;
    }

}
