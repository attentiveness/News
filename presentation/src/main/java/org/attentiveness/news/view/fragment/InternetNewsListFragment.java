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
import org.attentiveness.news.data.net.NewsService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsService.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsService newsService = retrofit.create(NewsService.class);
        Call<ChannelEntity> call = newsService.getChannelList();
        call.enqueue(new Callback<ChannelEntity>() {
            @Override
            public void onResponse(Call<ChannelEntity> call, Response<ChannelEntity> response) {
                Log.e("NetFragment", "response successful: " + response.isSuccessful());
                Log.e("NetFragment", response.body().toString());
            }

            @Override
            public void onFailure(Call<ChannelEntity> call, Throwable t) {
                Log.e("NetFragment", t.getMessage());
            }
        });
    }

}
