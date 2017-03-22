package org.attentiveness.news.list;


import android.os.Bundle;
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

    private RecyclerView mNewsListView;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        mNewsListView = (RecyclerView) rootView.findViewById(R.id.rv_news_list);
        return rootView;
    }

    @Override
    public void setPresenter(NewsListContract.Presenter presenter) {

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
