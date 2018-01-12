package com.example.interviewpractice.enity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 首页分类图标
 */
public class CategoryTab extends BmobObject {
    private String type;
    private BmobFile typeIcon;
    private String id;

    public CategoryTab(String type, BmobFile typeIcon, String id) {
        this.type = type;
        this.typeIcon = typeIcon;
        this.id=id;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public BmobFile getTypeIcon() {
        return typeIcon;
    }
    public void setTypeIcon(BmobFile typeIcon) {
        this.typeIcon = typeIcon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





}
