package org.attentiveness.news.channel;

import android.os.Bundle;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

public class NewsChannelActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_channel);

        init();
    }

    private void init() {
        NewsChannelFragment fragment = (NewsChannelFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (fragment == null) {
            fragment = NewsChannelFragment.newInstance();
            addFragment(getSupportFragmentManager(), R.id.fl_container, fragment);
        }
    }

}
