package com.niit.org.service;

import java.util.List;

import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.dto.SubscribeDTO;

public interface CollectionService {

	public int insertCollection(SubscribeDTO subscribeDTO) ;
	
	public int deleteCollection(SubscribeDTO subscribeDTO);
	
    public String queryStatus(SubscribeDTO subscribeDTO); 
    
    public List<LiveRoomDTO> getMyCollect(Integer id) ;
}
