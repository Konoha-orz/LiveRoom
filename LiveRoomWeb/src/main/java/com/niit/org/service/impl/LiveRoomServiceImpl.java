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
	public List<LiveRoomDTO> queryRoomById(Integer roomId) {
		
		return ilrs.queryRoomById(roomId);
	}

	@Override
	public List<LiveRoomDTO> getListByType(String type) {
		
		return ilrs.getListByType(type);
	}

	@Override
	public List<LiveRoomDTO> getHotList() {
		// TODO Auto-generated method stub
		return ilrs.getHotList();
	}

	@Override
	public List<LiveRoomDTO> getListByType(String type, int num) {
		// TODO Auto-generated method stub
		return ilrs.getListByTypeInNum(type, num);
	}

}
