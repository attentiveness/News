package org.attentiveness.news.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;

import butterknife.ButterKnife;

/**
 * Tech News List
 */
public class TechNewsListFragment extends BaseFragment {

    public static TechNewsListFragment newInstance() {
        TechNewsListFragment fragment = new TechNewsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public TechNewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tech_news_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
