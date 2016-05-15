package org.attentiveness.news.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.attentiveness.news.R;
import org.attentiveness.news.internal.di.HasComponent;
import org.attentiveness.news.internal.di.components.DaggerNewsComponent;
import org.attentiveness.news.internal.di.components.NewsComponent;
import org.attentiveness.news.view.fragment.EducationNewsListFragment;
import org.attentiveness.news.view.fragment.InternetNewsListFragment;
import org.attentiveness.news.view.fragment.FinanceNewsListFragment;
import org.attentiveness.news.view.fragment.TechNewsListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,
        HasComponent<NewsComponent> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.tl_channels)
    TabLayout mTlChannels;
    @BindView(R.id.vp_news_list)
    ViewPager mVpNewsList;

    private NewsComponent mNewsComponent;
    private static String[] mTabTexts = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initInjector();
        init();
    }

    private void initInjector() {
        mNewsComponent = DaggerNewsComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void init() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        mTabTexts = getResources().getStringArray(R.array.tab_text_array);
        mVpNewsList.setAdapter(new NewsListAdapter(getSupportFragmentManager()));
        mTlChannels.setupWithViewPager(mVpNewsList);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public NewsComponent getComponent() {
        return mNewsComponent;
    }

    private static class NewsListAdapter extends FragmentStatePagerAdapter {

        private Fragment fragment;

        public NewsListAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment = InternetNewsListFragment.newInstance();
                    break;
                case 1:
                    fragment = TechNewsListFragment.newInstance();
                    break;
                case 2:
                    fragment = FinanceNewsListFragment.newInstance();
                    break;
                case 3:
                    fragment = EducationNewsListFragment.newInstance();
                    break;
                default:
                    fragment = InternetNewsListFragment.newInstance();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTexts[position];
        }
    }
}
