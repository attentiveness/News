package org.attentiveness.news.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.attentiveness.news.R;
import org.attentiveness.news.data.Story;

import java.util.ArrayList;
import java.util.List;

class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private List<Story> mStoryList;

    public NewsListAdapter() {
        this.mStoryList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Story story = this.mStoryList.get(position);
        List<String> imageUrlList = story.getImageList();
        String imageUrl = null;
        if (imageUrlList != null && imageUrlList.size() > 0) {
            imageUrl = imageUrlList.get(0);
        }
        ImageView imageView = holder.mImageView;
        TextView titleView = holder.mTitleView;
        titleView.setText(story.getTitle());
        Picasso.with(holder.mImageView.getContext()).load(imageUrl).error(R.mipmap.ic_launcher).into(imageView);
    }

    @Override
    public int getItemCount() {
        return mStoryList.size();
    }

    void setItemList(List<Story> list) {
        if (list == null) {
            throw new IllegalArgumentException("The arguments must not be null.");
        }
        this.mStoryList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTitleView;

        ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_img);
            mTitleView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
