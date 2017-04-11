package org.attentiveness.news.base;


import android.support.annotation.NonNull;

public interface BaseView<T> {

    void setPresenter(@NonNull T presenter);

    void setLoadingIndicator(boolean active);

    void showRetry();

    void hideRetry();

    void showError(String message);

    boolean isActive();
}
