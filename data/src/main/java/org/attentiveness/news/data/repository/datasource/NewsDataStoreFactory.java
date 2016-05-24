package org.attentiveness.news.data.repository.datasource;

import android.content.Context;

import org.attentiveness.news.data.net.RestApi;
import org.attentiveness.news.data.net.RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * News Data Store Factory
 */
@Singleton
public class NewsDataStoreFactory {

    private Context mContext;

    @Inject
    public NewsDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.mContext = context.getApplicationContext();
    }

    public NewsDataStore createCloudDataStore() {
        RestApi restApi = RestApiImpl.getInstance(mContext);
        return new CloudNewsDataStore(restApi);
    }

}
