package org.attentiveness.news.list;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;
import org.attentiveness.news.data.News;

import java.util.List;

/**
 * News list fragment.
 */
public class NewsListFragment extends BaseFragment implements NewsListContract.View {

    private NewsListContract.Presenter mPresenter;
    private RecyclerView mNewsListView;
    private NewsListAdapter mNewsListAdapter;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mNewsListAdapter = new NewsListAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        mNewsListView = (RecyclerView) rootView.findViewById(R.id.rv_news_list);
        return rootView;
    }

    @Override
    public void setPresenter(@NonNull NewsListContract.Presenter presenter) {
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
    public void showNewsList(List<News> newsList) {

    }

    @Override
    public void showNewsDetailsUi(String url) {

    }

    @Override
    public void showNewsMarkedRead() {

    }

    @Override
    public void showLoadingNewsError() {

    }

    @Override
    public void showNoNews() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
