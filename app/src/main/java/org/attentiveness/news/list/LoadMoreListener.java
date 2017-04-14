package org.attentiveness.news.list;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

abstract class LoadMoreListener extends RecyclerView.OnScrollListener {

    private int mPreviousTotal = 0;
    private boolean mLoading = true;
    private LinearLayoutManager mLinearLayoutManager;

    LoadMoreListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dy > 0 && this.mLinearLayoutManager != null) //check for scroll down
        {
            int visibleItemCount = this.mLinearLayoutManager.getChildCount();
            int totalItemCount = this.mLinearLayoutManager.getItemCount();
            int firstVisibleItem = this.mLinearLayoutManager.findFirstVisibleItemPosition();

            if (this.mLoading) {
                if (totalItemCount > this.mPreviousTotal) {
                    this.mLoading = false;
                    this.mPreviousTotal = totalItemCount;
                }
            }
            int visibleThreshold = 1;
            if (!this.mLoading && totalItemCount > visibleItemCount
                    && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                this.onLoadMore();
                this.mLoading = true;
            }
        }
    }

    abstract void onLoadMore();
}
