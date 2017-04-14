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

import butterknife.BindView;
import butterknife.ButterKnife;

class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.ViewHolder> {

    interface OnItemClickListener {
        void onStoryClicked(Story story);
    }

    private List<Story> mStoryList;
    private OnItemClickListener mOnItemClickListener;

    StoryListAdapter() {
        this.mStoryList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Story story = this.mStoryList.get(position);
        List<String> imageUrlList = story.getImageList();
        String imageUrl = null;
        if (imageUrlList != null && imageUrlList.size() > 0) {
            imageUrl = imageUrlList.get(0);
        }
        ImageView imageView = holder.mImageView;
        TextView titleView = holder.mTitleView;
        titleView.setText(story.getTitle());
        Picasso.with(holder.mImageView.getContext()).load(imageUrl).error(R.mipmap.ic_launcher).into(imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onStoryClicked(story);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mStoryList.size();
    }

    void setItemList(List<Story> list) {
        if (list == null) {
            throw new IllegalArgumentException("The arguments must not be null.");
        }
        this.mStoryList = list;
        notifyDataSetChanged();
    }

    void addItemList(List<Story> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mStoryList.addAll(list);
        notifyDataSetChanged();
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_img)
        ImageView mImageView;
        @BindView(R.id.tv_title)
        TextView mTitleView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
