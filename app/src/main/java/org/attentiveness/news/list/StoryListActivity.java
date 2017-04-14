package org.attentiveness.news.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;
import org.attentiveness.news.data.source.StoriesDataRepository;
import org.attentiveness.news.data.source.local.LocalStoriesDataSource;
import org.attentiveness.news.data.source.remote.RemoteStoriesDataSource;
import org.attentiveness.news.util.DateUtil;

import butterknife.ButterKnife;

public class StoryListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        ButterKnife.bind(this);
        setup(R.drawable.ic_menu);

        StoryListFragment newsListFragment = (StoryListFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (newsListFragment == null) {
            String today = DateUtil.getToday();
            newsListFragment = StoryListFragment.newInstance(today);
            addFragment(getSupportFragmentManager(), R.id.fl_container, newsListFragment);
        }

        StoriesDataRepository repository = StoriesDataRepository.getInstance(
                RemoteStoriesDataSource.getInstance(this), LocalStoriesDataSource.getInstance(this));
        StoryListPresenter presenter = new StoryListPresenter(repository, newsListFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                if (this.mDrawerLayout != null) {
                    this.mDrawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.nav_news_list:
                        //do nothing
                        break;
                    case R.id.nav_feedback:
                        break;
                    case R.id.nav_about:
                        break;
                    case R.id.nav_settings:
                        break;
                    default:
                        break;
                }
                // Close the navigation drawer when an item is selected.
                item.setChecked(true);
                if (mDrawerLayout != null) {
                    mDrawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }

}
