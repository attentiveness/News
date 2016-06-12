package org.attentiveness.news.base;


import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class UseCase {

    protected PostExecutionThread mPostExecutionThread;
    protected ThreadExecutor mThreadExecutor;
    protected Subscription mSubscription = Subscriptions.empty();

    public UseCase() {
        this.mPostExecutionThread = UIThread.getInstance();
        this.mThreadExecutor = JobExecutor.getInstance();
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

}
