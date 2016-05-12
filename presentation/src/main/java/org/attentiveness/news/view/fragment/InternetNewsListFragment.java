package org.attentiveness.news.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;

import butterknife.ButterKnife;

/**
 * Internet News List
 */
public class InternetNewsListFragment extends BaseFragment {



    public static InternetNewsListFragment newInstance() {
        InternetNewsListFragment fragment = new InternetNewsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public InternetNewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_internet_news_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
