package com.niit.org.mapper;

import com.niit.org.dto.SubscribeDTO;

public interface CollectionMapper {

	public int insertCollect(SubscribeDTO subscribeDTO);
	
	public int deleteCollect(SubscribeDTO subscribeDTO);
	
	public String queryStatus(SubscribeDTO subscribeDTO);
	
	
}
