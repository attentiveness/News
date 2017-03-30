package org.attentiveness.news.detail;

import android.os.Bundle;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;
import org.attentiveness.news.list.NewsListFragment;

public class NewsDetailActivity extends BaseActivity {

    private int mStoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        setup();

        this.mStoryId = getIntent().getIntExtra(NewsListFragment.EXTRA_ID, 0);


        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.cl_container);
        if (newsDetailFragment == null) {
            newsDetailFragment = NewsDetailFragment.newInstance(this.mStoryId);
            addFragment(getSupportFragmentManager(), R.id.cl_container, newsDetailFragment);
        }

        NewsDetailPresenter presenter = new NewsDetailPresenter(newsDetailFragment);
    }

}
