package org.attentiveness.news.list;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

abstract class LoadMoreListener extends RecyclerView.OnScrollListener {

    private int mPreviousTotal = 0;
    private boolean mLoading = false;
    private int mCurrentPage = 1;
    private LinearLayoutManager mLinearLayoutManager;

    LoadMoreListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = mLinearLayoutManager.getItemCount();
        int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false;
                mPreviousTotal = totalItemCount;
            }
        }
        int visibleThreshold = 1;
        if (!mLoading && totalItemCount > visibleItemCount
                && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            mCurrentPage++;
            onLoadMore(mCurrentPage);
            mLoading = true;
        }
    }

    public abstract void onLoadMore(int currentPage);
}
