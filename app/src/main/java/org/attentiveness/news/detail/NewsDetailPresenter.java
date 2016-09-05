package org.attentiveness.news.detail;


public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.View mView;
    private NewsDetailUseCase mUseCase;

    public NewsDetailPresenter(NewsDetailContract.View view) {
        this.mView = view;
        this.mUseCase = new NewsDetailUseCase();
    }

    @Override
    public void destroy() {
        mUseCase.unsubscribe();
    }

}
