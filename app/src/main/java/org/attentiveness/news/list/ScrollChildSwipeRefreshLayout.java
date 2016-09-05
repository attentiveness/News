package org.attentiveness.news.list;


import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

public class ScrollChildSwipeRefreshLayout extends SwipeRefreshLayout {

    private View mChildView;

    public ScrollChildSwipeRefreshLayout(Context context) {
        super(context);
    }

    public ScrollChildSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canChildScrollUp() {
        if (mChildView != null) {
            return ViewCompat.canScrollVertically(mChildView, -1);
        }
        return super.canChildScrollUp();
    }

    public void setChildView(View childView) {
        this.mChildView = childView;
    }
}
