package com.niit.org.service;

import java.util.List;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;

public interface LiveRoomService {

	public List<LiveRoomDTO> queryAllLiveRoom();
	public List<LiveRoomDTO> searchByKey(String key);
	public List<LiveRoomDTO> queryRoomById(Integer roomId) ;
	public List<LiveRoomDTO> getListByType(String type);
	public List<LiveRoomDTO> getListByType(String type,int num);
	public List<LiveRoomDTO> getHotList();
}
