package org.attentiveness.news.base;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Base Fragment
 */
public class BaseFragment extends Fragment {

    public BaseFragment() {
        // Required empty public constructor
    }

    protected void showMessage(View anchorView, String message) {
        Snackbar.make(anchorView, message, Snackbar.LENGTH_SHORT).show();
    }

}
