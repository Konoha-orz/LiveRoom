package com.niit.org.bean;

import java.util.Calendar;

/**
 * 一个具体的格式来确保服务端和客户端消息格式的一致性
 * 
 * 
 * Msg creator 创建者（系统，用户）
 * Msg msgBody 消息
 * Msg sTime   发送的时间
 * Msg roomId  对应的房间ID
 * 
 * 
 * */
public class Msg {
    private static final long serialVersionUID = 1l;
    private String creator;
    private String msgBody;
    private Calendar sTime;
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCreator() {
        return creator;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public Calendar getsTime() {
        return sTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void setsTime(Calendar sTime) {
        this.sTime = sTime;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "creator='" + creator + '\'' +
                ", msgBody='" + msgBody + '\'' +
                ", sTime=" + sTime +
                '}';
    }
}
