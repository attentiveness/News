package org.attentiveness.news.base;


import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

public class UIThread implements PostExecutionThread {

    private static UIThread INSTANCE = null;

    private UIThread() {
        //empty
    }

    public static UIThread getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UIThread();
        }
        return INSTANCE;
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
