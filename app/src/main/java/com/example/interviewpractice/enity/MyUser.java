package com.example.interviewpractice.enity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by 鱼握拳 on 2018/3/23.
 */

public class MyUser extends BmobUser {
    public BmobFile getAvatar() {
        return avatar;
    }

    public void setAvatar(BmobFile avatar) {
        this.avatar = avatar;
    }

    private BmobFile avatar;
}
