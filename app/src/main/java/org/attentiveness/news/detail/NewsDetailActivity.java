package org.attentiveness.news.detail;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private String mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            mLink = getIntent().getStringExtra(NewsDetailFragment.LINK);
        } else {
            mLink = savedInstanceState.getString(NewsDetailFragment.LINK);
        }
        NewsDetailFragment fragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (fragment == null) {
            fragment = NewsDetailFragment.newInstance(mLink);
            addFragment(getSupportFragmentManager(), R.id.fl_container, fragment);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(NewsDetailFragment.LINK, mLink);
    }
}
