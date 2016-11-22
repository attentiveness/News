package org.attentiveness.news.list;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;
import org.attentiveness.news.data.News;
import org.attentiveness.news.detail.NewsDetailActivity;
import org.attentiveness.news.detail.NewsDetailFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewsListFragment extends BaseFragment implements NewsListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.rv_news_list)
    RecyclerView mRvNewsList;
    @Bind(R.id.btn_retry)
    Button mBtnRetry;
    @Bind(R.id.srl_refresh_news)
    ScrollChildSwipeRefreshLayout mSrlRefreshNews;

    private NewsListContract.Presenter mPresenter;
    private NewsListAdapter mAdapter;
    private String mChannelId = "5572a109b3cdc86cf39001db"; //
    private int mCurrentPage = 1;
    private int mNeedContent = 0;
    private int mNeedHtml = 0;
    private int mTotalPages = 1;

    public NewsListFragment() {
        // Required empty public constructor
    }

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        setupSwipeRefreshLayout();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void setupRecyclerView() {
        mAdapter = new NewsListAdapter(getActivity());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRvNewsList.setHasFixedSize(true);
        mRvNewsList.setLayoutManager(manager);
        mRvNewsList.setAdapter(mAdapter);
        LoadMoreListener listener = new LoadMoreListener(manager) {
            /**
             * Load more items when SwipeRefreshLayout or its child layout is scrolled upward.
             */
            @Override
            public void onLoadMore(int currentPage) {
                if (currentPage <= mTotalPages) {
                    mAdapter.setHasMoreData(true);
                    mCurrentPage = currentPage;
                    Log.e("load more", "current page: " + mCurrentPage);
                    mPresenter.getNewsList(false, mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
                } else {
                    mAdapter.setHasMoreData(false);
                }
            }
        };
        mRvNewsList.addOnScrollListener(listener);
    }

    private void setupSwipeRefreshLayout() {
        mSrlRefreshNews.setChildView(mRvNewsList);
        mSrlRefreshNews.setOnRefreshListener(this);
        mSrlRefreshNews.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light, android.R.color.holo_green_light);
    }

    private void init() {
        mPresenter = new NewsListPresenter(this);
        mPresenter.getTotalPage(mChannelId);
        mPresenter.getNewsList(true, mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
    }

    @Override
    public void saveTotalPage(int totalPage) {
        mTotalPages = totalPage;
    }

    @Override
    public void renderFirstPage(List<News> newsList) {
        mAdapter.replaceItemList(newsList);
        mRvNewsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void appendPage(List<News> newsList) {
        mAdapter.appendItemList(newsList);
        mRvNewsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        showMessage(mRvNewsList, message);
        mRvNewsList.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mSrlRefreshNews.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSrlRefreshNews.setRefreshing(false);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * Refresh items when SwipeRefreshLayout or its child layout is swiped downward.
     */
    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        mPresenter.getNewsList(true, mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
    }

    @OnClick(R.id.btn_retry)
    void requestNewsList() {
        mCurrentPage = 1;
        mPresenter.getNewsList(true, mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
    }

    private NewsListAdapter.OnItemClickListener mOnItemClickListener = new NewsListAdapter.OnItemClickListener() {
        @Override
        public void onItemClicked(News news) {
            if (news != null && news.getLink() != null) {
                startActivity(new Intent(getActivity(), NewsDetailActivity.class).putExtra(NewsDetailFragment.LINK, news.getLink()));
            }
        }
    };

}
