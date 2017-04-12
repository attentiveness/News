package org.attentiveness.news.util.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;


public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
