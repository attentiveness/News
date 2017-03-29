package org.attentiveness.news.detail;

import android.os.Bundle;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

public class NewsDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        setup();

        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.cl_container);
        if (newsDetailFragment == null) {
            newsDetailFragment = NewsDetailFragment.newInstance();
            addFragment(getSupportFragmentManager(), R.id.cl_container, newsDetailFragment);
        }

        NewsDetailPresenter presenter = new NewsDetailPresenter(newsDetailFragment);
    }

}
