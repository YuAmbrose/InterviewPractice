package com.example.interviewpractice.enity;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/2/12.
 */

public class PrevueBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : http://p1.meituan.net/movie/407589f2a2bbc08490b6b16f25fcd65229007.jpg
         * movieId : 1211482
         * movieName : 熊出没·变形记
         * name : 郁可唯暖心归家曲《像小时候一样》MV 大年初一合家团聚
         * originName : 暖心归家曲《像小时候一样》MV 大年初一合家团聚
         * url : http://maoyan.meituan.net/movie/videos/854x480606a06c627354938ac06e70009528dfb.mp4
         * videoId : 91695
         * wish : 95149
         */

        private String img;
        private int movieId;
        private String movieName;
        private String name;
        private String originName;
        private String url;
        private int videoId;
        private int wish;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }
    }
}
