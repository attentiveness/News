package org.attentiveness.news.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetailFragment extends BaseFragment implements NewsDetailContract.View {

    @Bind(R.id.wv_content)
    WebView mWvContent;
    @Bind(R.id.btn_retry)
    Button mBtnRetry;
    @Bind(R.id.pb_loading)
    ProgressBar mPbLoading;

    public final static String LINK = "link";

    private String mLink;
    private NewsDetailContract.Presenter mPresenter;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    public static NewsDetailFragment newInstance(String link) {
        Bundle bundle = new Bundle();
        bundle.putString(LINK, link);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLink = getArguments().getString(LINK);
        init();
    }

    private void init() {
        mPresenter = new NewsDetailPresenter(this);
        mWvContent.loadUrl(mLink);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        mBtnRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        mBtnRetry.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
