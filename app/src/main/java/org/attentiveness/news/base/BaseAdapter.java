package org.attentiveness.news.base;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.attentiveness.news.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {

    enum VIEW_TYPE {
        TYPE_ITEM,
        TYPE_FOOTER
    }

    protected List<T> mItemList = new ArrayList<>();
    protected boolean mHasMoreData;

    public BaseAdapter() {
        //empty
    }

    //Content itemViewHolder
    public abstract VH onCreateItemViewHolder(ViewGroup parent, int viewType);

    //Content itemViewHolder
    public abstract void onBindItemViewHolder(final VH holder, int position);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE.TYPE_ITEM.ordinal()) {
            return onCreateItemViewHolder(parent, viewType);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
            return new FooterViewHolder(view);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            if (mHasMoreData) {
                ((FooterViewHolder) holder).mRlLoading.setVisibility(View.VISIBLE);
                ((FooterViewHolder) holder).mRlNoMoreData.setVisibility(View.GONE);
            } else {
                ((FooterViewHolder) holder).mRlLoading.setVisibility(View.GONE);
                ((FooterViewHolder) holder).mRlNoMoreData.setVisibility(View.VISIBLE);
            }
        } else {
            onBindItemViewHolder((VH) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mItemList.size()) {
            return VIEW_TYPE.TYPE_ITEM.ordinal();
        } else {
            return VIEW_TYPE.TYPE_FOOTER.ordinal();
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.rl_loading)
        RelativeLayout mRlLoading;
        @Bind(R.id.rl_no_more_data)
        RelativeLayout mRlNoMoreData;

        public FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
