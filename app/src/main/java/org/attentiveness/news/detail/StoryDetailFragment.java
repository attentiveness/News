package org.attentiveness.news.detail;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;
import org.attentiveness.news.data.StoryDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * News Detail Fragment
 */
public class StoryDetailFragment extends BaseFragment implements StoryDetailContract.View {

    @BindView(R.id.fl_root_view)
    FrameLayout mRootView;
    @BindView(R.id.wv_view)
    WebView mWebView;
    @BindView(R.id.tv_loading_error)
    TextView mRetryView;

    private StoryDetailContract.Presenter mPresenter;

    public static StoryDetailFragment newInstance() {
        return new StoryDetailFragment();
    }

    public StoryDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);
        ButterKnife.bind(this, view);

        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void setPresenter(@NonNull StoryDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mPresenter.unsubscribe();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showRetry() {
        this.mRetryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.mRetryView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showMessage(this.mRootView, message);
    }

    @Override
    public void showStoryDetail(StoryDetail comment) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
