package org.attentiveness.news.newsdetail;


import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NewsDetailPresenterTest {

    @Mock
    private NewsDetailContract.View mView;

    @Mock
    private NewsDetailUseCase mUseCase;

    private NewsDetailPresenter mPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mPresenter = new NewsDetailPresenter(mView);
    }

}
