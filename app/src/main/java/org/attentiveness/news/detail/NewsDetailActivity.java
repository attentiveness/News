package org.attentiveness.news.detail;

import android.os.Bundle;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;
import org.attentiveness.news.list.NewsListFragment;

public class NewsDetailActivity extends BaseActivity {

    private static final String INSTANCE_STORY_ID = "story_id";

    private int mStoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        setup();

        if (savedInstanceState == null) {
            this.mStoryId = getIntent().getIntExtra(NewsListFragment.EXTRA_ID, 0);
        } else {
            this.mStoryId = savedInstanceState.getInt(INSTANCE_STORY_ID);
        }

        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (newsDetailFragment == null) {
            newsDetailFragment = NewsDetailFragment.newInstance(this.mStoryId);
            addFragment(getSupportFragmentManager(), R.id.fl_container, newsDetailFragment);
        }

        NewsDetailPresenter presenter = new NewsDetailPresenter(newsDetailFragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(INSTANCE_STORY_ID, this.mStoryId);
    }
}
