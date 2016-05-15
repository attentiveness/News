package org.attentiveness.news.internal.di.components;

import org.attentiveness.news.internal.di.PerActivity;
import org.attentiveness.news.internal.di.modules.ActivityModule;
import org.attentiveness.news.internal.di.modules.NewsModule;
import org.attentiveness.news.view.fragment.InternetNewsListFragment;

import dagger.Component;

/**
 * News Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, NewsModule.class})
public interface NewsComponent extends ActivityComponent {

    void inject(InternetNewsListFragment fragment);
}
