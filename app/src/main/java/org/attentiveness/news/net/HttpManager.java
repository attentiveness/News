package org.attentiveness.news.net;

import org.attentiveness.news.data.Story;

import java.util.List;

/**
 * Http Manager that responds to url request.
 */
public class HttpManager {

    private static HttpManager INSTANCE = null;

    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HttpManager();
        }
        return INSTANCE;
    }

    private HttpManager() {
    }

    public List<Story> getStoryList() {
        return null;
    }

    public Story getStory(int storyId) {
        return null;
    }

}
