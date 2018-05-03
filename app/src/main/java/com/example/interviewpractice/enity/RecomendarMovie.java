package com.example.interviewpractice.enity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2018/1/25.
 */

public class RecomendarMovie extends BmobObject {
    private String movieUrl;
    private BmobFile imageUrl;
    private String description;
    public RecomendarMovie(){}
    public RecomendarMovie(String id) {
            setObjectId(id);
    }

    public String getImagepng() {
        return imagepng;
    }

    public void setImagepng(String imagepng) {
        this.imagepng = imagepng;
    }

    private String  imagepng;

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public BmobFile getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(BmobFile imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
