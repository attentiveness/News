package org.attentiveness.news.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.attentiveness.news.model.NewsModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Internet News List Adapter
 */
public class InternetNewsAdapter extends RecyclerView.Adapter<InternetNewsAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<NewsModel> mNewsModels;

    public InternetNewsAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mNewsModels = Collections.emptyList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mNewsModels != null ? this.mNewsModels.size() : 0;
    }

    public void setNewsList(Collection<NewsModel> collection) {
        this.validateCollection(collection);
        this.mNewsModels = (List<NewsModel>) collection;
    }

    private void validateCollection(Collection<NewsModel> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("This list must not be null.");
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
