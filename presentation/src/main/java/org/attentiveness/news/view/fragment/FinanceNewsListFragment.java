package org.attentiveness.news.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.R;

import butterknife.ButterKnife;

/**
 * Finance News List
 */
public class FinanceNewsListFragment extends BaseFragment {

    public static FinanceNewsListFragment newInstance() {
        return new FinanceNewsListFragment();
    }

    public FinanceNewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finance_news_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
