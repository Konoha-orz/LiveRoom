package com.niit.org.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.dto.SubscribeDTO;

public interface CollectionMapper {

	public int insertCollect(SubscribeDTO subscribeDTO);
	
	public int deleteCollect(SubscribeDTO subscribeDTO);
	
	public String queryStatus(SubscribeDTO subscribeDTO);
	
	public List<LiveRoomDTO> getMyList(@Param("id")Integer id);
}
