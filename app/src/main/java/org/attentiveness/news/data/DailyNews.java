package org.attentiveness.news.data;


import java.util.List;

public class DailyNews {

    private String date;
    private List<Story> stories;

    public DailyNews(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "DailyNews{" +
                "date=" + date +
                ", stories=" + stories +
                '}';
    }
}
