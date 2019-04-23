package com.lcz.geek.bean.Zhihu;

import java.util.List;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class RibaoBean {

    /**
     * date : 20190411
     * stories : [{"title":"丝袜是怎么成为女性专属品的？","ga_prefix":"041109","images":["https://pic3.zhimg.com/v2-6fe4ab7108c6ea12660b2d57f621efaa.jpg"],"multipic":true,"type":0,"id":9710124},{"title":"人类首张黑洞照片正式发布，爱因斯坦竟然叕对了","ga_prefix":"041107","images":["https://pic1.zhimg.com/v2-b767fbe31568c651fe08394b3ec65764.jpg"],"multipic":true,"type":0,"id":9710133},{"images":["https://pic4.zhimg.com/v2-1e4bb0c13422bd8c1d4e3038fcfd49ab.jpg"],"type":0,"id":9710027,"ga_prefix":"041106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-3931ed35e8f77cb1751292d15c03c9a1.jpg","type":0,"id":9710133,"ga_prefix":"041107","title":"人类首张黑洞照片正式发布，爱因斯坦竟然叕对了"},{"image":"https://pic2.zhimg.com/v2-502358da76d1aa22fea9f4203de7dbed.jpg","type":0,"id":9710100,"ga_prefix":"041007","title":"审美的败落，从宣扬「丑」开始"},{"image":"https://pic1.zhimg.com/v2-f3f4fa67b1a8dd4c4fa1e20ed46273dc.jpg","type":0,"id":9709933,"ga_prefix":"040907","title":"年轻人在被学校和公司压榨上，为什么看起来会如此相似？"},{"image":"https://pic1.zhimg.com/v2-438b4bee17ac7dd1e8eaeea701d618a8.jpg","type":0,"id":9710023,"ga_prefix":"040821","title":"年度神剧的最佳一集，就是它了"},{"image":"https://pic1.zhimg.com/v2-f1868f01be028cef75f703887f0bf864.jpg","type":0,"id":9710040,"ga_prefix":"040818","title":"两个人吵架，最恐怖的莫过于\u2026\u2026被翻旧账"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 丝袜是怎么成为女性专属品的？
         * ga_prefix : 041109
         * images : ["https://pic3.zhimg.com/v2-6fe4ab7108c6ea12660b2d57f621efaa.jpg"]
         * multipic : true
         * type : 0
         * id : 9710124
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-3931ed35e8f77cb1751292d15c03c9a1.jpg
         * type : 0
         * id : 9710133
         * ga_prefix : 041107
         * title : 人类首张黑洞照片正式发布，爱因斯坦竟然叕对了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
