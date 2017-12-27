package com.example.interviewpractice.enity;

import java.util.List;

/**
 * 首页banner
 * Created by 鱼握拳 on 2017/12/19.
 */

public class BannerBean {

    private List<ItemListBean> itemList;

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * type : video
         * data : {"title":"特条 | 褪下两件战袍，科比依旧伟大","cover":{"feed":"http://img.kaiyanapp.com/96e805a815906124b7fb280dc6a7fe77.jpeg?imageMogr2/quality/60/format/jpg"},"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=67609","forWeibo":"http://www.eyepetizer.net/detail.html?vid=67609"}}
         */

        private String type;
        private DataBean data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * title : 特条 | 褪下两件战袍，科比依旧伟大
             * cover : {"feed":"http://img.kaiyanapp.com/96e805a815906124b7fb280dc6a7fe77.jpeg?imageMogr2/quality/60/format/jpg"}
             * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=67609","forWeibo":"http://www.eyepetizer.net/detail.html?vid=67609"}
             */

            private String title;
            private CoverBean cover;
            private WebUrlBean webUrl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrlBean webUrl) {
                this.webUrl = webUrl;
            }

            public static class CoverBean {
                /**
                 * feed : http://img.kaiyanapp.com/96e805a815906124b7fb280dc6a7fe77.jpeg?imageMogr2/quality/60/format/jpg
                 */

                private String feed;

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }
            }

            public static class WebUrlBean {
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=67609
                 * forWeibo : http://www.eyepetizer.net/detail.html?vid=67609
                 */

                private String raw;
                private String forWeibo;

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }
        }
    }
}
