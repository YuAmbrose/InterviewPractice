package com.example.interviewpractice.enity;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public class Cag  extends BmobObject {
    private String name;
    private String  id;
    private String bgPicture;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(String bgPicture) {
        this.bgPicture = bgPicture;
    }




}
