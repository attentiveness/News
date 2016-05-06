package org.attentiveness.news.internal.di.modules;

import android.content.Context;

import org.attentiveness.news.AndroidApplication;
import org.attentiveness.news.UIThread;
import org.attentiveness.news.data.executor.JobExecutor;
import org.attentiveness.news.domain.executor.PostExecutionThread;
import org.attentiveness.news.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}

