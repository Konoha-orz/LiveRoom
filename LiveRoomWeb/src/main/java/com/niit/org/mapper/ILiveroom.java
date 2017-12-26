package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;

public interface ILiveroom {
	public List<LiveRoom> getLiveroom(int liveroomid);
	public List<LiveRoom> getAll();
	public List<LiveRoom> getLiveroomByUserid(int userid);
	public void createLiveroom(LiveRoom liveroom);
	public List<LiveRoomDTO> queryLiveRoomById(int userid);
 }
