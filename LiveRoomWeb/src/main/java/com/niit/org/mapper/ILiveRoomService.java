package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.LiveRoom;

public interface ILiveRoomService {
 
	public List<LiveRoom> queryAllLiveRoom() ;
		
	public LiveRoom queryRoomById(Integer roomId);
}
