package com.niit.org.dto;

import java.io.Serializable;

public class SubscribeDTO implements Serializable{

	private String userId;
	private String roomId;
	
	/*关注状态值,0不关注,1关注*/
	private String isCollect;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
	}



	
	
	
	
	
}
