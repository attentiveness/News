package org.attentiveness.news.domain.interactor;

import org.attentiveness.news.domain.executor.PostExecutionThread;
import org.attentiveness.news.domain.executor.ThreadExecutor;
import org.attentiveness.news.domain.repository.NewsRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Get News List Use Case
 */
public class GetNewsList extends UseCase {

    private NewsRepository mNewsRepository;

    @Inject
    public GetNewsList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, NewsRepository newsRepository) {
        super(threadExecutor, postExecutionThread);
        this.mNewsRepository = newsRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mNewsRepository.getNewsList();
    }
}
