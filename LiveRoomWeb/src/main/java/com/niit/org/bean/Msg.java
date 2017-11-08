package com.niit.org.bean;

import java.util.Calendar;

/**
 * 一个具体的格式来确保服务端和客户端消息格式的一致性
 * 
 * 
 * Msg creator 创建者（系统，用户）
 * Msg msgBody 消息
 * Msg sTime 发送的时间
 * Msg roomId 对应的房间ID
 * Msg roomNumbers 对应房间的人数
 * 
 * 
 */
public class Msg {
	private static final long serialVersionUID = 1l;
	private String creator;
	private String msgBody;
	private Calendar sTime;
	private String roomId;
	private Integer roomNumbers;

	public Msg() {
		Calendar cal = Calendar.getInstance() ;
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		this.setsTime(cal);	
	}
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

	public Integer getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(Integer roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	@Override
	public String toString() {
		return "MsgEntity{" + "creator='" + creator + '\'' + ", msgBody='" + msgBody + '\'' + ", sTime=" + sTime + '}';
	}
}
