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

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;
import org.attentiveness.news.data.StoryDetail;

import java.util.List;

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
    public void showError(String message) {
        this.showMessage(this.mRootView, message);
    }

    @Override
    public void showStoryDetail(StoryDetail storyDetail) {
        if (!this.isActive() || getView() == null) {
            return;
        }
        if (storyDetail == null) {
            return;
        }
        String body = storyDetail.getContent();
        List<String> jsArray = storyDetail.getJsList();
        if (jsArray != null && jsArray.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < jsArray.size(); index++) {
                String jsLink = "<script type=\"text/javascript\" src=\"" + jsArray.get(index) + "\"></script>";
                stringBuilder.append(jsLink);
            }
            body = stringBuilder.toString() + body;
        }
        List<String> cssArray = storyDetail.getCssList();
        if (cssArray != null && cssArray.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < cssArray.size(); index++) {
                String cssLink = "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + cssArray.get(index) + "\" />";
                stringBuilder.append(cssLink);
            }
            body = stringBuilder.toString() + body;
        }
        this.mWebView.loadData(body, "text/html; charset=UTF-8", null);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
