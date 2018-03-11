package com.example.interviewpractice.enity;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/10.
 */

public class EyReplyBean {

    /**
     * replyList : [{"id":831064217002967040,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":831064217002967040,"sequence":5,"message":"人不如猫系列","replyStatus":"PUBLISHED","createTime":1486976124000,"user":{"uid":300411872,"nickname":"Gateau","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5320xc83ZQib13P39ZJRF1joh4qhoB9xuEsRhXztoDZ2f4SMze6trdy5cCz3QRn0O8HRwduNyVFia9RmOiak00ueIHo2AODShgmc/0","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":null,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/300411872/?title=Gateau&userType=NORMAL&tabIndex=0"},"likeCount":3,"liked":false,"hot":true,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"831064217002967040","userBlocked":false},{"id":893284988194127872,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":893284988194127872,"sequence":7,"message":"根本不是蛋糕，明明是肉泥","replyStatus":"PUBLISHED","createTime":1501810712000,"user":{"uid":300009297,"nickname":"\".~Moda~.\"","avatar":"http://qzapp.qlogo.cn/qzapp/1104373357/593BE52A73B9B76B1074237BB772B55F/100","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":1475071857000,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/300009297/?title=%22.~Moda~.%22&userType=NORMAL&tabIndex=0"},"likeCount":0,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"893284988194127872","userBlocked":false},{"id":889018854762610688,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":889018854762610688,"sequence":6,"message":"猫咪都感动哭了，不舍得吃\u2026\u2026","replyStatus":"PUBLISHED","createTime":1500793587000,"user":{"uid":300890905,"nickname":"半杯红酒半杯可乐","avatar":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLJ5xZkibyKBX1ZCxCvDtzGOBCG9rD9eMT1tibcCODfWDmtdTW1icoZMPecyKeLdedZqY2GeQyUglibiag/0","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":1500715063000,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/300890905/?title=%E5%8D%8A%E6%9D%AF%E7%BA%A2%E9%85%92%E5%8D%8A%E6%9D%AF%E5%8F%AF%E4%B9%90&userType=NORMAL&tabIndex=0"},"likeCount":0,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"889018854762610688","userBlocked":false},{"id":804978202597392384,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":804978202597392384,"sequence":4,"message":"那个猫 眼泪汪汪的","replyStatus":"PUBLISHED","createTime":1480756734000,"user":{"uid":227036062,"nickname":"何香","avatar":"http://img.wdjimg.com/image/account/5656ebbb7dc432bb530422b2c2d6f018_300_300.png","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":1471603583000,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/227036062/?title=%E4%BD%95%E9%A6%99&userType=NORMAL&tabIndex=0"},"likeCount":1,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"804978202597392384","userBlocked":false},{"id":762804468105379840,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":762804468105379840,"sequence":3,"message":"猫好看哎","replyStatus":"PUBLISHED","createTime":1470701732000,"user":{"uid":225028730,"nickname":"recall","avatar":"http://img.wdjimg.com/image/account/3d93b7055575a404b084e0104715270e_300_300.png","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":null,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/225028730/?title=recall&userType=NORMAL&tabIndex=0"},"likeCount":1,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"762804468105379840","userBlocked":false},{"id":697129004976586752,"videoId":2490,"videoTitle":"三文鱼慕斯蛋糕","parentReplyId":0,"rootReplyId":697129004976586752,"sequence":2,"message":"太可爱了","replyStatus":"PUBLISHED","createTime":1455043481000,"user":{"uid":202418158,"nickname":"751464590","avatar":"http://img.wdjimg.com/image/video/2aaffd3671e48e308e675a72bc203a45_240_240.jpeg","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":null,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/202418158/?title=751464590&userType=NORMAL&tabIndex=0"},"likeCount":0,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"sid":"697129004976586752","userBlocked":false}]
     * count : 6
     * total : 6
     * nextPageUrl : null
     */

    private int count;
    private int total;
    private Object nextPageUrl;
    private List<ReplyListBean> replyList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<ReplyListBean> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyListBean> replyList) {
        this.replyList = replyList;
    }

    public static class ReplyListBean {
        /**
         * id : 831064217002967040
         * videoId : 2490
         * videoTitle : 三文鱼慕斯蛋糕
         * parentReplyId : 0
         * rootReplyId : 831064217002967040
         * sequence : 5
         * message : 人不如猫系列
         * replyStatus : PUBLISHED
         * createTime : 1486976124000
         * user : {"uid":300411872,"nickname":"Gateau","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5320xc83ZQib13P39ZJRF1joh4qhoB9xuEsRhXztoDZ2f4SMze6trdy5cCz3QRn0O8HRwduNyVFia9RmOiak00ueIHo2AODShgmc/0","userType":"NORMAL","ifPgc":false,"description":null,"area":null,"gender":null,"registDate":null,"releaseDate":null,"cover":null,"actionUrl":"eyepetizer://pgc/detail/300411872/?title=Gateau&userType=NORMAL&tabIndex=0"}
         * likeCount : 3
         * liked : false
         * hot : true
         * userType : null
         * type : video
         * actionUrl : null
         * imageUrl :
         * ugcVideoId : null
         * sid : 831064217002967040
         * userBlocked : false
         */

        private long id;
        private int videoId;
        private String videoTitle;
        private int parentReplyId;
        private long rootReplyId;
        private int sequence;
        private String message;
        private String replyStatus;
        private long createTime;
        private UserBean user;
        private int likeCount;
        private boolean liked;
        private boolean hot;
        private Object userType;
        private String type;
        private Object actionUrl;
        private String imageUrl;
        private Object ugcVideoId;
        private String sid;
        private boolean userBlocked;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getParentReplyId() {
            return parentReplyId;
        }

        public void setParentReplyId(int parentReplyId) {
            this.parentReplyId = parentReplyId;
        }

        public long getRootReplyId() {
            return rootReplyId;
        }

        public void setRootReplyId(long rootReplyId) {
            this.rootReplyId = rootReplyId;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getReplyStatus() {
            return replyStatus;
        }

        public void setReplyStatus(String replyStatus) {
            this.replyStatus = replyStatus;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public boolean isHot() {
            return hot;
        }

        public void setHot(boolean hot) {
            this.hot = hot;
        }

        public Object getUserType() {
            return userType;
        }

        public void setUserType(Object userType) {
            this.userType = userType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(Object actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getUgcVideoId() {
            return ugcVideoId;
        }

        public void setUgcVideoId(Object ugcVideoId) {
            this.ugcVideoId = ugcVideoId;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public boolean isUserBlocked() {
            return userBlocked;
        }

        public void setUserBlocked(boolean userBlocked) {
            this.userBlocked = userBlocked;
        }

        public static class UserBean {
            /**
             * uid : 300411872
             * nickname : Gateau
             * avatar : http://wx.qlogo.cn/mmopen/Q3auHgzwzM5320xc83ZQib13P39ZJRF1joh4qhoB9xuEsRhXztoDZ2f4SMze6trdy5cCz3QRn0O8HRwduNyVFia9RmOiak00ueIHo2AODShgmc/0
             * userType : NORMAL
             * ifPgc : false
             * description : null
             * area : null
             * gender : null
             * registDate : null
             * releaseDate : null
             * cover : null
             * actionUrl : eyepetizer://pgc/detail/300411872/?title=Gateau&userType=NORMAL&tabIndex=0
             */

            private int uid;
            private String nickname;
            private String avatar;
            private String userType;
            private boolean ifPgc;
            private Object description;
            private Object area;
            private Object gender;
            private Object registDate;
            private Object releaseDate;
            private Object cover;
            private String actionUrl;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public boolean isIfPgc() {
                return ifPgc;
            }

            public void setIfPgc(boolean ifPgc) {
                this.ifPgc = ifPgc;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getRegistDate() {
                return registDate;
            }

            public void setRegistDate(Object registDate) {
                this.registDate = registDate;
            }

            public Object getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(Object releaseDate) {
                this.releaseDate = releaseDate;
            }

            public Object getCover() {
                return cover;
            }

            public void setCover(Object cover) {
                this.cover = cover;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }
        }
    }
}
