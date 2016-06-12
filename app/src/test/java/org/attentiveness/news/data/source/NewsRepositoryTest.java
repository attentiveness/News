package org.attentiveness.news.data.source;


import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NewsRepositoryTest {

    @Mock
    private NewsDataSource mLocalDataSource;

    @Mock
    private NewsDataSource mRemoteDataSource;

    @Mock
    private Context mContext;

    private NewsRepository mRepository;
    private String mChannelId;
    private int mCurrentPage;
    private int mNeedContent;
    private int mNeedHtml;

    @Before
    public void setupNewsRepository() {
        MockitoAnnotations.initMocks(this);
        this.mRepository = NewsRepository.getInstance(mContext);
    }

    @Test
    public void getNewsList() {
        when(mChannelId).thenReturn("5572a109b3cdc86cf39001db");
        when(mCurrentPage).thenReturn(1);
        when(mNeedContent).thenReturn(0);
        when(mNeedHtml).thenReturn(0);
        mRepository.getNewsList(mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
        verify(mRepository).getNewsList(mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
    }

}