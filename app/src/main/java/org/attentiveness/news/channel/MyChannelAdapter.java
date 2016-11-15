package org.attentiveness.news.channel;


import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.attentiveness.news.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

class MyChannelAdapter extends RecyclerView.Adapter<MyChannelAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked(String channelName);
    }

    private List<String> mItemList;
    private boolean mIsEditable;
    private OnItemClickListener mListener;

    MyChannelAdapter() {
        this.mItemList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_channel, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final String channelName = mItemList.get(position);
        holder.mTvChannelName.setText(channelName);
        if (mIsEditable) {
            holder.mIvRemove.setVisibility(View.VISIBLE);
            holder.mIvRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(position);
                }
            });
        } else {
            holder.mIvRemove.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClicked(channelName);
                }
            }
        });
    }

    private void removeItem(int position) {
        mItemList.remove(position);
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() : 0;
    }

    public void setItemList(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("The list must not be null.");
        }
        mItemList = list;
        notifyDataSetChanged();
    }

    public void setEditable(boolean isEditable) {
        mIsEditable = isEditable;
    }

    public void setOnItemListener(OnItemClickListener listener) {
        if (listener != null) {
            mListener = listener;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_channel_name)
        TextView mTvChannelName;
        @Bind(R.id.iv_remove)
        ImageView mIvRemove;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
