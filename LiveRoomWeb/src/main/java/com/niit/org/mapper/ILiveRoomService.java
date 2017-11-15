package com.niit.org.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;

public interface ILiveRoomService {
 
	public List<LiveRoom> queryAllLiveRoom() ;
    
	public List<LiveRoomDTO> searchByKey(@Param(value="key") String key);
	
	
	
}
