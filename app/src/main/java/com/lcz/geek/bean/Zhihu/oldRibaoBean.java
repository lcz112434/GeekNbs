package com.lcz.geek.bean.Zhihu;

import java.util.List;

/**
 * Created by 李承泽 on 2019/4/18.
 */
public class oldRibaoBean {

    /**
     * date : 20190312
     * stories : [{"images":["https://pic3.zhimg.com/v2-f3bf19564b0f94b9f42fe8617fc262ea.jpg"],"type":0,"id":9708828,"ga_prefix":"031222","title":"小事 · 一句道歉没那么难，真的"},{"images":["https://pic1.zhimg.com/v2-716cf34b78f8d2263138f68ae2bfa484.jpg"],"type":0,"id":9708740,"ga_prefix":"031221","title":"《流浪地球》最终票房会超过《战狼 2》吗？"},{"images":["https://pic3.zhimg.com/v2-37eb62e64ba0084c0a371e731d658c0a.jpg"],"type":0,"id":9708783,"ga_prefix":"031218","title":"齐祖回归，他能挽救困境中的皇马吗？"},{"title":"选购洁面产品，先要知道你脸上想洗掉的到底是什么","ga_prefix":"031216","images":["https://pic3.zhimg.com/v2-a2e2a4c25246c2c63804593415888196.jpg"],"multipic":true,"type":0,"id":9708789},{"title":"艾弗森绝对会从右侧过了你，可惜，你就是防不住","ga_prefix":"031209","images":["https://pic1.zhimg.com/v2-45faee4f7ee4514ae22a6640cf76951c.jpg"],"multipic":true,"type":0,"id":9708764},{"images":["https://pic4.zhimg.com/v2-dce76aa3c6bd3a824c89acbd2db24e33.jpg"],"type":0,"id":9708777,"ga_prefix":"031208","title":"没开玩笑，演了总统的喜剧演员，即将被选为总统"},{"title":"我混进了 00 后的 QQ 群，发现自己真的老了","ga_prefix":"031207","images":["https://pic2.zhimg.com/v2-8c65084a1e96476bf484830b86119009.jpg"],"multipic":true,"type":0,"id":9708771},{"images":["https://pic3.zhimg.com/v2-f59bd80ff355ab9cbed1c575c5251ca2.jpg"],"type":0,"id":9708756,"ga_prefix":"031206","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

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

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-f3bf19564b0f94b9f42fe8617fc262ea.jpg"]
         * type : 0
         * id : 9708828
         * ga_prefix : 031222
         * title : 小事 · 一句道歉没那么难，真的
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

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

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
