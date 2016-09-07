package org.attentiveness.news.channel;


import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewsChannelFragment extends BaseFragment {

    @Bind(R.id.gl_my_channel_list)
    GridLayout mGlMyChannelList;
    @Bind(R.id.gl_channel_list_recommended)
    GridLayout mGlChannelListRecommended;

    public static NewsChannelFragment newInstance() {
        return new NewsChannelFragment();
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
