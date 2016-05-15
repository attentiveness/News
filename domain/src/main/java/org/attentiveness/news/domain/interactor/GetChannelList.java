package org.attentiveness.news.domain.interactor;

import org.attentiveness.news.domain.executor.PostExecutionThread;
import org.attentiveness.news.domain.executor.ThreadExecutor;
import org.attentiveness.news.domain.repository.NewsRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Get Channel List Use Case
 */
public class GetChannelList extends UseCase {

    private NewsRepository mNewsRepository;

    @Inject
    public GetChannelList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                          NewsRepository newsRepository) {
        super(threadExecutor, postExecutionThread);
        this.mNewsRepository = newsRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mNewsRepository.getChannelList();
    }
}
