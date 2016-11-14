package org.attentiveness.news.channel;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NewsChannelFragment extends BaseFragment {

    @Bind(R.id.gl_my_channel_list)
    GridLayout mGlMyChannelList;
    @Bind(R.id.gl_channel_list_recommended)
    GridLayout mGlChannelListRecommended;
    @Bind(R.id.btn_edit_or_done)
    Button mBtnEditOrDone;
    @Bind(R.id.iv_remove)
    ImageView mIvRemove;

    private BUTTON_STATUS mStatus;
    private List<String> mMyChannelList;
    private List<String> mChannelRecommendedList;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mStatus = BUTTON_STATUS.DONE;
        mMyChannelList = new ArrayList<>();
        mChannelRecommendedList = new ArrayList<>();
        //update two channel lists


        updateViews();
    }

    @OnClick(R.id.tv_close)
    void closeScreen() {
        getActivity().finish();
    }

    @OnClick(R.id.iv_remove)
    void removeItem(){

    }

    @OnClick(R.id.btn_edit_or_done)
    void editOrDone() {
        if (mBtnEditOrDone.getText().toString().equals(getString(R.string.btn_edit))) {
            mBtnEditOrDone.setText(getString(R.string.btn_done));
            mStatus = BUTTON_STATUS.EDITABLE;
        } else {
            mBtnEditOrDone.setText(getString(R.string.btn_edit));
            mStatus = BUTTON_STATUS.DONE;
        }
        updateViews();
    }

    private void updateViews() {
        if (mStatus == BUTTON_STATUS.EDITABLE) {
            mIvRemove.setVisibility(View.VISIBLE);
//            updateTextViews(mGlMyChannelList, true);
        } else {
            mIvRemove.setVisibility(View.GONE);
//            updateTextViews(mGlMyChannelList, false);
        }
    }

    private void updateTextViews(View parent, boolean showClose) {
        GridLayout gridLayout;
        if (parent instanceof GridLayout) {
            gridLayout = (GridLayout) parent;
        } else {
            return;
        }
        for (int i = 0; i < mMyChannelList.size(); i++) {
            FrameLayout frameLayout = (FrameLayout) gridLayout.getChildAt(i);
            TextView textView = (TextView) frameLayout.getChildAt(0);
            textView.setText(mMyChannelList.get(i));
            ImageView imageView = (ImageView) gridLayout.getChildAt(1);
            if (showClose) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
            frameLayout.setVisibility(View.VISIBLE);
        }
        if (mMyChannelList.size() < gridLayout.getChildCount()) {
            for (int i = mMyChannelList.size(); i <= gridLayout.getChildCount(); i++) {
                FrameLayout frameLayout = (FrameLayout) gridLayout.getChildAt(i);
                frameLayout.setVisibility(View.INVISIBLE);
            }
        }
    }

    public enum BUTTON_STATUS {
        EDITABLE,
        DONE
    }

}
