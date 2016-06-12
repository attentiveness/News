package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page {

    @SerializedName("pagebean")
    private Body body;

    @SerializedName("ret_code")
    private int code;

    public Page() {
        //empty
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public class Body {

        @SerializedName("allNum")
        private int totalNewsNum;

        @SerializedName("allPages")
        private int totalPagesNum;

        @SerializedName("currentPage")
        private int currentPageNum;

        @SerializedName("maxResult")
        private int maxNewsNumInPage;

        @SerializedName("contentlist")
        private List<News> newsList;

        public Body() {
            //empty
        }

        public int getTotalNewsNum() {
            return totalNewsNum;
        }

        public void setTotalNewsNum(int totalNewsNum) {
            this.totalNewsNum = totalNewsNum;
        }

        public int getTotalPagesNum() {
            return totalPagesNum;
        }

        public void setTotalPagesNum(int totalPagesNum) {
            this.totalPagesNum = totalPagesNum;
        }

        public int getCurrentPageNum() {
            return currentPageNum;
        }

        public void setCurrentPageNum(int currentPageNum) {
            this.currentPageNum = currentPageNum;
        }

        public int getMaxNewsNumInPage() {
            return maxNewsNumInPage;
        }

        public void setMaxNewsNumInPage(int maxNewsNumInPage) {
            this.maxNewsNumInPage = maxNewsNumInPage;
        }

        public List<News> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<News> newsList) {
            this.newsList = newsList;
        }

        @Override
        public String toString() {
            return "Page{" +
                    "totalNewsNum=" + totalNewsNum +
                    ", totalPagesNum=" + totalPagesNum +
                    ", currentPageNum=" + currentPageNum +
                    ", maxNewsNumInPage=" + maxNewsNumInPage +
                    ", newsList=" + newsList +
                    "}";
        }
    }

}
