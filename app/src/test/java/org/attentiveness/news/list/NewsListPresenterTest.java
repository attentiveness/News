package org.attentiveness.news.list;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NewsListPresenterTest {

    @Mock
    private NewsListContract.View mView;

    @Mock
    private NewsListUseCase mUseCase;

    private NewsListPresenter mPresenter;
    private boolean mForceRefresh;
    private String mChannelId;
    private int mCurrentPage;
    private int mNeedContent;
    private int mNeedHtml;

    @Before
    public void setup() {
        this.mPresenter = new NewsListPresenter(mView);
    }

    @Test
    public void getNewsList() {
        when(mForceRefresh).thenReturn(true);
        when(mChannelId).thenReturn("5572a109b3cdc86cf39001db");
        when(mCurrentPage).thenReturn(1);
        when(mNeedContent).thenReturn(0);
        when(mNeedHtml).thenReturn(0);
        mPresenter.getNewsList(mForceRefresh, mChannelId, mCurrentPage, mNeedContent, mNeedHtml);
        verify(mUseCase).refresh();
    }

}
