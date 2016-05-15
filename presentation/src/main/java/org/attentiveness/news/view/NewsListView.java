package org.attentiveness.news.view;

import org.attentiveness.news.model.NewsModel;

import java.util.Collection;

/**
 * News List View
 */
public interface NewsListView extends LoadDataView {

    void renderNewsList(Collection<NewsModel> newsModelCollection);
}
