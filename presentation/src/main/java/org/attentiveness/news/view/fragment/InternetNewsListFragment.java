package org.attentiveness.news.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.internal.di.components.NewsComponent;
import org.attentiveness.news.model.NewsModel;
import org.attentiveness.news.presenter.NewsListPresenter;
import org.attentiveness.news.view.NewsListView;
import org.attentiveness.news.view.adapter.InternetNewsAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Internet News List
 */
public class InternetNewsListFragment extends BaseFragment implements NewsListView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_news_list)
    RecyclerView mRvInternetNewsList;
    @BindView(R.id.srl_refresh_news)
    SwipeRefreshLayout mSrlNews;

    @Inject
    NewsListPresenter mNewsListPresenter;
    @Inject
    InternetNewsAdapter mInternetNewsAdapter;

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
        setupRecyclerView();
        setupSwipeRefreshLayout();
        return view;
    }

    private void setupRecyclerView() {
        mRvInternetNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvInternetNewsList.setAdapter(mInternetNewsAdapter);
    }

    private void setupSwipeRefreshLayout() {
        mSrlNews.setOnRefreshListener(this);
        mSrlNews.setColorSchemeColors(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
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

    @Override
    public void renderNewsList(Collection<NewsModel> newsModelCollection) {
        mInternetNewsAdapter.setNewsList(newsModelCollection);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSrlNews.setRefreshing(false);
            }
        }, 5000);
    }
}
