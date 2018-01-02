package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.Liveroom;
import com.niit.org.dto.LiveRoomDTO;

public interface ILiveroom {
	public List<Liveroom> getLiveroom(int liveroomid);
	public List<Liveroom> getAll();
	public List<Liveroom> getLiveroomByUserid(int userid);
	public void createLiveroom(Liveroom liveroom);
	public List<LiveRoomDTO> queryLiveRoomById(int userid);
	public void updateLiveroom(Liveroom liveroom);
	public void openLiveroom(int userid);
	public void closeLiveroom(int userid);
 }
