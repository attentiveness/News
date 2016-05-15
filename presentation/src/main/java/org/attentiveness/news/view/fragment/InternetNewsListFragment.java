package org.attentiveness.news.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.internal.di.components.NewsComponent;
import org.attentiveness.news.presenter.NewsListPresenter;
import org.attentiveness.news.view.NewsListView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Internet News List
 */
public class InternetNewsListFragment extends BaseFragment implements NewsListView {

    @BindView(R.id.rv_news_list)
    RecyclerView mRvInternetNewsList;

    @Inject
    NewsListPresenter mNewsListPresenter;

    public static InternetNewsListFragment newInstance() {
        return new InternetNewsListFragment();
    }

    public InternetNewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(NewsComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_internet_news_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNewsListPresenter.setView(this);
        init();
    }

    private void init() {
        mNewsListPresenter.init();
    }

    @Override
    public void onResume() {
        super.onResume();
        mNewsListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mNewsListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mNewsListPresenter.destroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity();
    }
}
