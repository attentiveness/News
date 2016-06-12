package org.attentiveness.news.newslist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.attentiveness.news.R;
import org.attentiveness.news.base.BaseAdapter;
import org.attentiveness.news.data.News;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsListAdapter extends BaseAdapter<News, NewsListAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClicked(News news);
    }

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public NewsListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, int position) {
        final News news = mItemList.get(position);
        holder.mTvTitle.setText(news.getTitle());
        holder.mTvPubDate.setText(news.getPubDate());
        holder.mTvSource.setText(news.getSource());
        String url = news.getImgUrls() != null && news.getImgUrls().length > 0 ? news.getImgUrls()[0].getUrl() : "";
        if (!"".equals(url)) {
            Picasso.with(mContext).load(url).into(holder.mIvNews);
        } else {
            Picasso.with(mContext).load(R.mipmap.ic_launcher).into(holder.mIvNews);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClicked(news);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void replaceItemList(List<News> list) {
        mItemList.clear();
        mItemList = list;
        notifyDataSetChanged();
    }

    public void setHasMoreData(boolean hasMoreData) {
        mHasMoreData = hasMoreData;
    }

    public void appendItemList(List<News> list) {
        mItemList.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_news)
        ImageView mIvNews;
        @Bind(R.id.tv_title)
        TextView mTvTitle;
        @Bind(R.id.tv_pub_date)
        TextView mTvPubDate;
        @Bind(R.id.tv_source)
        TextView mTvSource;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
