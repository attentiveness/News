package org.attentiveness.news.base;


import rx.Scheduler;

public interface PostExecutionThread {

    Scheduler getScheduler();
}
