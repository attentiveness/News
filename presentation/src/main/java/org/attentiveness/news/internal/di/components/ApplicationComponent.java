package org.attentiveness.news.internal.di.components;

import android.content.Context;

import org.attentiveness.news.domain.executor.PostExecutionThread;
import org.attentiveness.news.domain.executor.ThreadExecutor;
import org.attentiveness.news.internal.di.modules.ApplicationModule;
import org.attentiveness.news.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

}