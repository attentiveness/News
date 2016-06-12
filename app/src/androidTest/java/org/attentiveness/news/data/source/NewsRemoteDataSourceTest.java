package org.attentiveness.news.data.source;


import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.attentiveness.news.data.source.remote.NewsRemoteDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewsRemoteDataSourceTest {

    private NewsRemoteDataSource mNewsRemoteDataSource;

    @Before
    public void setup() {
        this.mNewsRemoteDataSource = NewsRemoteDataSource.getInstance();
    }

    @After
    public void cleanup() {
        mNewsRemoteDataSource.deleteAllNews();
    }

}
