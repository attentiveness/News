package org.attentiveness.news.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;

/**
 * News Detail Fragment
 */
public class NewsDetailFragment extends BaseFragment implements NewsDetailContract.View {

    private NewsDetailContract.Presenter mPresenter;

    public static NewsDetailFragment newInstance() {
        return new NewsDetailFragment();
    }

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void setPresenter(@NonNull NewsDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mPresenter.start();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showNewsDetailUi() {

    }

    @Override
    public void showLoadingNewsDetailError() {

    }

    @Override
    public void showNoNewsDetail() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
