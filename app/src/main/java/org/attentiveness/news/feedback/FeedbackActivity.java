package org.attentiveness.news.feedback;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

public class FeedbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
