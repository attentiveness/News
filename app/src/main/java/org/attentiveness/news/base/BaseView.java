package org.attentiveness.news.base;


import android.content.Context;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    Context getContext();
}
