package org.attentiveness.news.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.attentiveness.news.R;

import butterknife.BindView;

/**
 * Base Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @Nullable
    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    @Nullable
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setup() {
        setup(-1);
    }

    protected void setup(int barIconId) {
        setSupportActionBar(this.mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (barIconId > 0) {
                actionBar.setHomeAsUpIndicator(barIconId);
            }
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (this.mDrawerLayout != null) {
            this.mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        }
        if (this.mNavigationView != null) {
            setupDrawerContent(this.mNavigationView);
        }
    }

    protected void setupDrawerContent(NavigationView navigationView) {

    }

    protected void addFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId, fragment);
        fragmentTransaction.commit();
    }

    protected void showMessage(View anchorView, String message) {
        Snackbar.make(anchorView, message, Snackbar.LENGTH_SHORT).show();
    }

}
