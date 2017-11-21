package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.Liveroom;

public interface ILiveroom {
	public List<Liveroom> getLiveroom(int liveroomid);
	public List<Liveroom> getAll();
	public List<Liveroom> getLiveroomByUserid(int userid);
	public void createLiveroom(Liveroom liveroom);
 }
