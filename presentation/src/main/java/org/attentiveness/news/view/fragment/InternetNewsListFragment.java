package org.attentiveness.news.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;
import org.attentiveness.news.data.entity.ChannelEntity;
import org.attentiveness.news.data.net.RestApi;
import org.attentiveness.news.data.net.RestApiImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Internet News List
 */
public class InternetNewsListFragment extends BaseFragment {

    @BindView(R.id.rv_news_list)
    RecyclerView mRvInternetNewsList;

    public static InternetNewsListFragment newInstance() {
        return new InternetNewsListFragment();
    }

    public InternetNewsListFragment() {
        // Required empty public constructor
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
        init();
    }

    private void init() {
        getChannelList();
    }

    private void getChannelList() {
        Subscriber<List<ChannelEntity>> subscriber = new Subscriber<List<ChannelEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("NetFragment", e.getMessage());
            }

            @Override
            public void onNext(List<ChannelEntity> channelEntityList) {
                if (channelEntityList == null) {
                    Log.e("NetFragment", "The list is null.");
                } else {
                    for (ChannelEntity channelEntity : channelEntityList) {
                        Log.e("NetFragment", channelEntity.toString());
                    }
                }
            }
        };
        RestApi restApi = RestApiImpl.getInstance();
        restApi.getChannelList()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
