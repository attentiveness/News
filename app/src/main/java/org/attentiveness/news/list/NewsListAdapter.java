package org.attentiveness.news.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    public NewsListAdapter() {

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
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
