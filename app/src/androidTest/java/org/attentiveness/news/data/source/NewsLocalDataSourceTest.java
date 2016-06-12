package org.attentiveness.news.data.source;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.attentiveness.news.data.source.local.NewsLocalDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewsLocalDataSourceTest {

    private NewsLocalDataSource mNewsLocalDataSource;

    @Before
    public void setup() {
        this.mNewsLocalDataSource = NewsLocalDataSource.getInstance(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void cleanup() {
        mNewsLocalDataSource.deleteAllNews();
    }

}
