package org.attentiveness.news.base;


import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobExecutor implements ThreadExecutor {

    private final static int INIT_SIZE = 3;
    private final static int MAX_SIZE = 5;
    private final static int KEEP_ALIVE_TIME = 10;
    private final static TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private static JobExecutor INSTANCE = null;

    private ThreadPoolExecutor mThreadPoolExecutor;

    private JobExecutor() {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = new JobThreadFactory();
        this.mThreadPoolExecutor = new ThreadPoolExecutor(INIT_SIZE, MAX_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, blockingQueue, threadFactory);
    }

    public static JobExecutor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JobExecutor();
        }
        return INSTANCE;
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    private class JobThreadFactory implements ThreadFactory {

        private final static String THREAD_NAME = "android_";
        private int counter = 0;

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, THREAD_NAME + counter++);
        }
    }

}
