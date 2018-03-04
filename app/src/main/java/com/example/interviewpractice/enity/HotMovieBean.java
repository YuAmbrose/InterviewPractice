package com.example.interviewpractice.enity;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/2/9.
 */

public class HotMovieBean {


    /**
     * data : {"boardtype":7,"content":"《每日热映口碑榜》\u2014\u2014将昨日国内热映的影片，按照评分从高到低排列，取前10名，每天上午10点更新，相关数据来源于\u201c猫眼专业版\u201d及\u201c猫眼电影库\u201d。","created":"2018-03-02","id":7,"movies":[{"dir":"卡比尔·汗","globalReleased":true,"id":343136,"img":"http://p1.meituan.net/w.h/movie/f042762fa4a975501b69d4f6af6520341035964.jpg","nm":"小萝莉的猴神大叔","pubDesc":"2018-03-02大陆上映","rt":"2018-03-02","sc":9.6,"star":"萨尔曼·汗,卡琳娜·卡普,哈尔莎莉·马尔霍特拉","wish":25381},{"dir":"林超贤","globalReleased":true,"id":1182552,"img":"http://p1.meituan.net/w.h/movie/82a01e8f773c273ba10b96b5acb06196381700.jpg","nm":"红海行动","pubDesc":"2018-02-16 08:00大陆上映","rt":"2018-02-16","sc":9.5,"star":"张译,黄景瑜,杜江","wish":160299},{"dir":"斯蒂芬·卓博斯基","globalReleased":true,"id":672130,"img":"http://p0.meituan.net/w.h/movie/862563dfea65ac947a149ce466f7f1771014432.jpg","nm":"奇迹男孩","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.3,"star":"雅各布·特瑞布雷,朱莉娅·罗伯茨,欧文·威尔逊","wish":48137},{"dir":"陈思诚","globalReleased":true,"id":344990,"img":"http://p1.meituan.net/w.h/movie/efb0a5e3989f45c4f3e22108bcc27ed71037307.jpg","nm":"唐人街探案2","pubDesc":"2018-02-16大陆上映","rt":"2018-02-16","sc":9.2,"star":"王宝强,刘昊然,肖央","wish":463427},{"dir":"丁亮,林汇达","globalReleased":true,"id":1211482,"img":"http://p0.meituan.net/w.h/movie/cec506a630a212cb68dcb7d09bfcc723762226.jpg","nm":"熊出没·变形记","pubDesc":"2018-02-16大陆上映","rt":"2018-02-16","sc":9.1,"star":"张伟,张秉君,谭笑","wish":112979},{"dir":"保罗·维尔奇","globalReleased":true,"id":667783,"img":"http://p1.meituan.net/w.h/movie/961642c88370bbabe018f5672dc24a581826950.jpg","nm":"爱在记忆消逝前","pubDesc":"2018-02-23大陆上映","rt":"2018-02-23","sc":9,"star":"海伦·米伦,唐纳德·萨瑟兰,简·默勒尼","wish":11738},{"dir":"迈克尔·格雷西","globalReleased":true,"id":246714,"img":"http://p0.meituan.net/w.h/movie/18121bb13bd8b36243a871d075bcc80c1015601.jpg","nm":"马戏之王","pubDesc":"2018-02-01大陆上映","rt":"2018-02-01","sc":9,"star":"休·杰克曼,扎克·埃夫隆,米歇尔·威廉姆斯","wish":16694},{"dir":"吴有音","globalReleased":true,"id":338493,"img":"http://p1.meituan.net/w.h/movie/b108468670aeaf1807182f832b17e37c1616889.jpg","nm":"南极之恋","pubDesc":"2018-02-01 18:00大陆上映","rt":"2018-02-01","sc":9,"star":"赵又廷,杨子姗","wish":42376},{"dir":"威尔·古勒","globalReleased":true,"id":343762,"img":"http://p1.meituan.net/w.h/movie/b0df0a3f7e07571c1193819c5a4f88ee827964.jpg","nm":"比得兔","pubDesc":"2018-03-02大陆上映","rt":"2018-03-02","sc":8.9,"star":"詹姆斯·柯登,多姆纳尔·格里森,萝丝·拜恩","wish":76484},{"dir":"兰城序","globalReleased":true,"id":1212787,"img":"http://p1.meituan.net/w.h/movie/43bd8761be0c81f94a4aaf45afdbd6654306495.jpg","nm":"坏爸爸","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":8.6,"star":"邵兵,孙绍龙,赵圆圆","wish":4111}],"paging":{"hasMore":false,"limit":10,"offset":0,"total":10},"shareHidden":1,"title":"每日热映口碑榜"}
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
         * created : 2018-03-02
         * id : 7
         * movies : [{"dir":"卡比尔·汗","globalReleased":true,"id":343136,"img":"http://p1.meituan.net/w.h/movie/f042762fa4a975501b69d4f6af6520341035964.jpg","nm":"小萝莉的猴神大叔","pubDesc":"2018-03-02大陆上映","rt":"2018-03-02","sc":9.6,"star":"萨尔曼·汗,卡琳娜·卡普,哈尔莎莉·马尔霍特拉","wish":25381},{"dir":"林超贤","globalReleased":true,"id":1182552,"img":"http://p1.meituan.net/w.h/movie/82a01e8f773c273ba10b96b5acb06196381700.jpg","nm":"红海行动","pubDesc":"2018-02-16 08:00大陆上映","rt":"2018-02-16","sc":9.5,"star":"张译,黄景瑜,杜江","wish":160299},{"dir":"斯蒂芬·卓博斯基","globalReleased":true,"id":672130,"img":"http://p0.meituan.net/w.h/movie/862563dfea65ac947a149ce466f7f1771014432.jpg","nm":"奇迹男孩","pubDesc":"2018-01-19大陆上映","rt":"2018-01-19","sc":9.3,"star":"雅各布·特瑞布雷,朱莉娅·罗伯茨,欧文·威尔逊","wish":48137},{"dir":"陈思诚","globalReleased":true,"id":344990,"img":"http://p1.meituan.net/w.h/movie/efb0a5e3989f45c4f3e22108bcc27ed71037307.jpg","nm":"唐人街探案2","pubDesc":"2018-02-16大陆上映","rt":"2018-02-16","sc":9.2,"star":"王宝强,刘昊然,肖央","wish":463427},{"dir":"丁亮,林汇达","globalReleased":true,"id":1211482,"img":"http://p0.meituan.net/w.h/movie/cec506a630a212cb68dcb7d09bfcc723762226.jpg","nm":"熊出没·变形记","pubDesc":"2018-02-16大陆上映","rt":"2018-02-16","sc":9.1,"star":"张伟,张秉君,谭笑","wish":112979},{"dir":"保罗·维尔奇","globalReleased":true,"id":667783,"img":"http://p1.meituan.net/w.h/movie/961642c88370bbabe018f5672dc24a581826950.jpg","nm":"爱在记忆消逝前","pubDesc":"2018-02-23大陆上映","rt":"2018-02-23","sc":9,"star":"海伦·米伦,唐纳德·萨瑟兰,简·默勒尼","wish":11738},{"dir":"迈克尔·格雷西","globalReleased":true,"id":246714,"img":"http://p0.meituan.net/w.h/movie/18121bb13bd8b36243a871d075bcc80c1015601.jpg","nm":"马戏之王","pubDesc":"2018-02-01大陆上映","rt":"2018-02-01","sc":9,"star":"休·杰克曼,扎克·埃夫隆,米歇尔·威廉姆斯","wish":16694},{"dir":"吴有音","globalReleased":true,"id":338493,"img":"http://p1.meituan.net/w.h/movie/b108468670aeaf1807182f832b17e37c1616889.jpg","nm":"南极之恋","pubDesc":"2018-02-01 18:00大陆上映","rt":"2018-02-01","sc":9,"star":"赵又廷,杨子姗","wish":42376},{"dir":"威尔·古勒","globalReleased":true,"id":343762,"img":"http://p1.meituan.net/w.h/movie/b0df0a3f7e07571c1193819c5a4f88ee827964.jpg","nm":"比得兔","pubDesc":"2018-03-02大陆上映","rt":"2018-03-02","sc":8.9,"star":"詹姆斯·柯登,多姆纳尔·格里森,萝丝·拜恩","wish":76484},{"dir":"兰城序","globalReleased":true,"id":1212787,"img":"http://p1.meituan.net/w.h/movie/43bd8761be0c81f94a4aaf45afdbd6654306495.jpg","nm":"坏爸爸","pubDesc":"2018-02-02大陆上映","rt":"2018-02-02","sc":8.6,"star":"邵兵,孙绍龙,赵圆圆","wish":4111}]
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
             * dir : 卡比尔·汗
             * globalReleased : true
             * id : 343136
             * img : http://p1.meituan.net/w.h/movie/f042762fa4a975501b69d4f6af6520341035964.jpg
             * nm : 小萝莉的猴神大叔
             * pubDesc : 2018-03-02大陆上映
             * rt : 2018-03-02
             * sc : 9.6
             * star : 萨尔曼·汗,卡琳娜·卡普,哈尔莎莉·马尔霍特拉
             * wish : 25381
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
