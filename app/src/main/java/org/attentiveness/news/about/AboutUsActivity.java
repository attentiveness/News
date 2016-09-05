package org.attentiveness.news.about;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseActivity;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
