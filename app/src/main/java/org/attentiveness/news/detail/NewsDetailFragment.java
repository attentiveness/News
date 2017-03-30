package org.attentiveness.news.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;
import org.attentiveness.news.list.NewsListFragment;

/**
 * News Detail Fragment
 */
public class NewsDetailFragment extends BaseFragment implements NewsDetailContract.View {

    private NewsDetailContract.Presenter mPresenter;
    private int mStoryId;

    public static NewsDetailFragment newInstance(int id) {
        NewsDetailFragment detailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NewsListFragment.EXTRA_ID, id);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mStoryId = getArguments().getInt(NewsListFragment.EXTRA_ID);
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
