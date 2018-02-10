package com.example.interviewpractice.enity;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieBean {

    /**
     * data : {"boardtype":7,"content":"《每日热映口碑榜》\u2014\u2014将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于\u201c猫眼专业版\u201d及\u201c猫眼电影库\u201d。","created":"2018-02-09","id":7,"movies":[{"dir":"阿德瓦·香登","globalReleased":true,"id":1208122,"img":"http://p0.meituan.net/w.h/movie/ba489e6ba90fe7b0110479c548797396585731.png","nm":"神秘巨星","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.5,"star":"阿米尔·汗,塞伊拉·沃西,梅·维贾","wish":46908},{"dir":"斯蒂芬·卓博斯基","globalReleased":true,"id":672130,"img":"http://p0.meituan.net/w.h/movie/862563dfea65ac947a149ce466f7f1771014432.jpg","nm":"奇迹男孩","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.3,"star":"雅各布·特瑞布雷,朱莉娅·罗伯茨,欧文·威尔逊","wish":48137},{"dir":"彭力","globalReleased":true,"id":1212979,"img":"http://p1.meituan.net/w.h/movie/d51997019cbc2487a79d79080819ce41998400.jpg","nm":"小狗奶瓶","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":9.3,"star":"奶瓶,康潇诺,魏子涵","wish":5682},{"dir":"卡洛斯·沙尔丹哈","globalReleased":true,"id":828745,"img":"http://p0.meituan.net/w.h/movie/80910ba7d9c2c4ee383cfe1e9a997828637397.jpg","nm":"公牛历险记","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.2,"star":"约翰·塞纳,莉莉·戴,凯特·迈克金农","wish":15741},{"dir":"田羽生","globalReleased":true,"id":344929,"img":"http://p0.meituan.net/w.h/movie/770b38cff221ad8545bf7bd3eba9912b1601613.jpg","nm":"前任3：再见前任","pubDesc":"2017-12-29大陆上映","rt":"2017-12-29","sc":9.2,"star":"韩庚,郑恺,于文文","wish":250058},{"dir":"李军林","globalReleased":true,"id":341323,"img":"http://p0.meituan.net/w.h/movie/5a9cfe47564e997f112c89daef67810c3461120.jpg","nm":"一个人的课堂","pubDesc":"2018-01-16大陆上映","rt":"2018-01-16","sc":9.2,"star":"孙海英,韩三明,王乃训","wish":1459},{"dir":"冯小刚","globalReleased":true,"id":1170264,"img":"http://p0.meituan.net/w.h/movie/fe0d4da87d70ba2b91e10ac98e0bf5ef1365131.png","nm":"芳华","pubDesc":"2017-12-15大陆上映","rt":"2017-12-15","sc":9.1,"star":"黄轩,苗苗,钟楚曦","wish":163381},{"dir":"吴有音","globalReleased":true,"id":338493,"img":"http://p1.meituan.net/w.h/movie/97bde8120bac903ff62d2f4c3b943ff6887193.jpg","nm":"南极之恋","pubDesc":"2018-02-01 18:00大陆上映","rt":"2018-02-01","sc":9,"star":"赵又廷,杨子姗","wish":42376},{"dir":"迈克尔·格雷西","globalReleased":true,"id":246714,"img":"http://p0.meituan.net/w.h/movie/18121bb13bd8b36243a871d075bcc80c1015601.jpg","nm":"马戏之王","pubDesc":"2018-02-01大陆上映","rt":"2018-02-01","sc":9,"star":"休·杰克曼,扎克·埃夫隆,米歇尔·威廉姆斯","wish":16694},{"dir":"杰森·西森","globalReleased":true,"id":1208748,"img":"http://p0.meituan.net/w.h/movie/0187900152d8667605609926065f14e2325061.jpg","nm":"小马宝莉大电影","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":8.9,"star":"奥卓·阿杜巴,艾米莉·布朗特,克里斯汀·肯诺恩斯","wish":29597}],"paging":{"hasMore":false,"limit":10,"offset":0,"total":10},"shareHidden":1,"title":"每日热映口碑榜"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * boardtype : 7
         * content : 《每日热映口碑榜》——将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于“猫眼专业版”及“猫眼电影库”。
         * created : 2018-02-09
         * id : 7
         * movies : [{"dir":"阿德瓦·香登","globalReleased":true,"id":1208122,"img":"http://p0.meituan.net/w.h/movie/ba489e6ba90fe7b0110479c548797396585731.png","nm":"神秘巨星","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.5,"star":"阿米尔·汗,塞伊拉·沃西,梅·维贾","wish":46908},{"dir":"斯蒂芬·卓博斯基","globalReleased":true,"id":672130,"img":"http://p0.meituan.net/w.h/movie/862563dfea65ac947a149ce466f7f1771014432.jpg","nm":"奇迹男孩","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.3,"star":"雅各布·特瑞布雷,朱莉娅·罗伯茨,欧文·威尔逊","wish":48137},{"dir":"彭力","globalReleased":true,"id":1212979,"img":"http://p1.meituan.net/w.h/movie/d51997019cbc2487a79d79080819ce41998400.jpg","nm":"小狗奶瓶","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":9.3,"star":"奶瓶,康潇诺,魏子涵","wish":5682},{"dir":"卡洛斯·沙尔丹哈","globalReleased":true,"id":828745,"img":"http://p0.meituan.net/w.h/movie/80910ba7d9c2c4ee383cfe1e9a997828637397.jpg","nm":"公牛历险记","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.2,"star":"约翰·塞纳,莉莉·戴,凯特·迈克金农","wish":15741},{"dir":"田羽生","globalReleased":true,"id":344929,"img":"http://p0.meituan.net/w.h/movie/770b38cff221ad8545bf7bd3eba9912b1601613.jpg","nm":"前任3：再见前任","pubDesc":"2017-12-29大陆上映","rt":"2017-12-29","sc":9.2,"star":"韩庚,郑恺,于文文","wish":250058},{"dir":"李军林","globalReleased":true,"id":341323,"img":"http://p0.meituan.net/w.h/movie/5a9cfe47564e997f112c89daef67810c3461120.jpg","nm":"一个人的课堂","pubDesc":"2018-01-16大陆上映","rt":"2018-01-16","sc":9.2,"star":"孙海英,韩三明,王乃训","wish":1459},{"dir":"冯小刚","globalReleased":true,"id":1170264,"img":"http://p0.meituan.net/w.h/movie/fe0d4da87d70ba2b91e10ac98e0bf5ef1365131.png","nm":"芳华","pubDesc":"2017-12-15大陆上映","rt":"2017-12-15","sc":9.1,"star":"黄轩,苗苗,钟楚曦","wish":163381},{"dir":"吴有音","globalReleased":true,"id":338493,"img":"http://p1.meituan.net/w.h/movie/97bde8120bac903ff62d2f4c3b943ff6887193.jpg","nm":"南极之恋","pubDesc":"2018-02-01 18:00大陆上映","rt":"2018-02-01","sc":9,"star":"赵又廷,杨子姗","wish":42376},{"dir":"迈克尔·格雷西","globalReleased":true,"id":246714,"img":"http://p0.meituan.net/w.h/movie/18121bb13bd8b36243a871d075bcc80c1015601.jpg","nm":"马戏之王","pubDesc":"2018-02-01大陆上映","rt":"2018-02-01","sc":9,"star":"休·杰克曼,扎克·埃夫隆,米歇尔·威廉姆斯","wish":16694},{"dir":"杰森·西森","globalReleased":true,"id":1208748,"img":"http://p0.meituan.net/w.h/movie/0187900152d8667605609926065f14e2325061.jpg","nm":"小马宝莉大电影","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":8.9,"star":"奥卓·阿杜巴,艾米莉·布朗特,克里斯汀·肯诺恩斯","wish":29597}]
         * paging : {"hasMore":false,"limit":10,"offset":0,"total":10}
         * shareHidden : 1
         * title : 每日热映口碑榜
         */

        private int boardtype;
        private String content;
        private String created;
        private int id;
        private PagingBean paging;
        private int shareHidden;
        private String title;
        private List<MoviesBean> movies;

        public int getBoardtype() {
            return boardtype;
        }

        public void setBoardtype(int boardtype) {
            this.boardtype = boardtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getShareHidden() {
            return shareHidden;
        }

        public void setShareHidden(int shareHidden) {
            this.shareHidden = shareHidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class PagingBean {
            /**
             * hasMore : false
             * limit : 10
             * offset : 0
             * total : 10
             */

            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class MoviesBean {
            /**
             * dir : 阿德瓦·香登
             * globalReleased : true
             * id : 1208122
             * img : http://p0.meituan.net/w.h/movie/ba489e6ba90fe7b0110479c548797396585731.png
             * nm : 神秘巨星
             * pubDesc : 2018-01-19大陆上映
             * rt : 2018-01-19
             * sc : 9.5
             * star : 阿米尔·汗,塞伊拉·沃西,梅·维贾
             * wish : 46908
             */

            private String dir;
            private boolean globalReleased;
            private int id;
            private String img;
            private String nm;
            private String pubDesc;
            private String rt;
            private double sc;
            private String star;
            private int wish;

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getPubDesc() {
                return pubDesc;
            }

            public void setPubDesc(String pubDesc) {
                this.pubDesc = pubDesc;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }
        }
    }
}
