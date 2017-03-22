package org.attentiveness.news.list;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
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
    private NewsListAdapter mNewsListAdapter;
    private RecyclerView mNewsListView;

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
        this.mNewsListView = (RecyclerView) rootView.findViewById(R.id.rv_news_list);
        this.mNewsListView.setAdapter(mNewsListAdapter);
        this.mNewsListView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ScrollChildSwipeRefreshLayout swipeRefreshLayout = (ScrollChildSwipeRefreshLayout) rootView.findViewById(R.id.rl_swipe_fresh_view);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );
        swipeRefreshLayout.setChildView(mNewsListView);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadNewsList(false);
            }
        });

        setHasOptionsMenu(true);
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
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl = (SwipeRefreshLayout) getView().findViewById(R.id.rl_swipe_fresh_view);

        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void showNewsList(List<News> newsList) {
        this.mNewsListAdapter.setItemList(newsList);
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
        return isAdded();
    }
}
