package org.attentiveness.news;

import android.app.Application;

import org.attentiveness.news.internal.di.components.ApplicationComponent;
import org.attentiveness.news.internal.di.components.DaggerApplicationComponent;
import org.attentiveness.news.internal.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
