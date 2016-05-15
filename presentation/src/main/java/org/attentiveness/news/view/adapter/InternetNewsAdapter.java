package org.attentiveness.news.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.attentiveness.news.R;
import org.attentiveness.news.model.NewsModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Internet News List Adapter
 */
public class InternetNewsAdapter extends RecyclerView.Adapter<InternetNewsAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<NewsModel> mNewsModels;

    @Inject
    public InternetNewsAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mNewsModels = Collections.emptyList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.row_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsModel newsModel = mNewsModels.get(position);
        holder.mTvTitle.setText(newsModel.getTitle());
        holder.mTvPubDate.setText(newsModel.getPubDate());
        holder.mTvSource.setText(newsModel.getSource());
        if (newsModel.getImgUrls() != null && newsModel.getImgUrls().length != 0) {
            String url = newsModel.getImgUrls()[0].getUrl();
            Picasso.with(mContext).load(url).into(holder.mIvNews);
            Log.e("NewsAdapter", "url: " + url);
        }
    }

    @Override
    public int getItemCount() {
        return this.mNewsModels != null ? this.mNewsModels.size() : 0;
    }

    public void setNewsList(Collection<NewsModel> collection) {
        validateCollection(collection);
        mNewsModels = (List<NewsModel>) collection;
        notifyDataSetChanged();
    }

    private void validateCollection(Collection<NewsModel> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("This list must not be null.");
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_news)
        ImageView mIvNews;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_pub_date)
        TextView mTvPubDate;
        @BindView(R.id.tv_source)
        TextView mTvSource;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
