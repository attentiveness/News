package org.attentiveness.news.detail;

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
public class NewsDetailScreenTest {

    @Rule
    private ActivityTestRule<NewsDetailActivity> mActivityTestRule = new ActivityTestRule<>(NewsDetailActivity.class);

    @Test
    public void renderWebView(){
        onView(withId(R.id.wv_content)).check(matches(isDisplayed()));
    }

}
