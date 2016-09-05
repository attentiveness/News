package org.attentiveness.news.channel;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewsChannelFragment extends BaseFragment {

    public static NewsChannelFragment newInstance() {
        Bundle args = new Bundle();
        NewsChannelFragment fragment = new NewsChannelFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public NewsChannelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_channel, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.tv_close)
    void closeScreen() {
        getActivity().finish();
    }

}
