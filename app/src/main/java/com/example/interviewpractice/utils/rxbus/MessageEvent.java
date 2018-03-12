package com.example.interviewpractice.utils.rxbus;

/**
 * Created by 鱼握拳 on 2018/3/12.
 */

public class MessageEvent {
    private String message;
    public MessageEvent(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
