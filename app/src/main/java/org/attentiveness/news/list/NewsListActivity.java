package org.attentiveness.news.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.attentiveness.news.R;
import org.attentiveness.news.about.AboutUsActivity;
import org.attentiveness.news.base.BaseActivity;
import org.attentiveness.news.channel.NewsChannelActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsListActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavView.setNavigationItemSelectedListener(this);

        NewsListFragment fragment = (NewsListFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (fragment == null) {
            fragment = NewsListFragment.newInstance();
            addFragment(getSupportFragmentManager(), R.id.fl_container, fragment);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_news_channel) {
            navigateToNewsChannel();
        } else if (id == R.id.nav_about_us) {
            navigateToAboutUs();
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void navigateToNewsChannel() {
        Intent intent = new Intent(this, NewsChannelActivity.class);
        startActivity(intent);
    }

    private void navigateToAboutUs() {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

}
