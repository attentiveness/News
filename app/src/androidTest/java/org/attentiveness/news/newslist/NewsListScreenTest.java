package org.attentiveness.news.newslist;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.attentiveness.news.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class NewsListScreenTest {

    @Rule
    private ActivityTestRule<NewsListActivity> mActivityTestRule = new ActivityTestRule<>(NewsListActivity.class);

    @Test
    public void renderNewsList() {
        onView(withId(R.id.rv_news_list)).check(matches(isDisplayed()));
    }

}
