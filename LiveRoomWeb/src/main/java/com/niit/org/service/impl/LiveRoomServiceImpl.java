package com.niit.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.mapper.ILiveRoomService;
import com.niit.org.service.LiveRoomService;

@Service("liveRoomService")
public class LiveRoomServiceImpl implements LiveRoomService{

	@Resource ILiveRoomService ilrs;
	
	@Override
	public List<LiveRoomDTO> queryAllLiveRoom() {
		
		return ilrs.queryAllLiveRoom();
	}

	@Override
	public List<LiveRoomDTO> searchByKey(String key) {
		return ilrs.searchByKey(key);
	}

	@Override
	public LiveRoom queryRoomById(Integer roomId) {
		
		return ilrs.queryRoomById(roomId);
	}

	@Override
	public List<LiveRoomDTO> getListByType(String type) {
		
		return ilrs.getListByType(type);
	}

}
