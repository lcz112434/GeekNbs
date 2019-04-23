package com.lcz.geek.bean.Zhihu;

import java.util.List;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class HotBean {

    private List<RecentBean> recent;

    public List<RecentBean> getRecent() {
        return recent;
    }

    public void setRecent(List<RecentBean> recent) {
        this.recent = recent;
    }

    public static class RecentBean {
        /**
         * news_id : 9709987
         * url : http://news-at.zhihu.com/api/2/news/9709987
         * thumbnail : https://pic3.zhimg.com/v2-ecde27b4bfde8bd59d554bf8647334ce.jpg
         * title : 瞎扯 · 如何正确地吐槽
         */

        private int news_id;
        private String url;
        private String thumbnail;
        private String title;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
