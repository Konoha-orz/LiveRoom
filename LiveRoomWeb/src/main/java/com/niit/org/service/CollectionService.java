package com.niit.org.service;

import com.niit.org.dto.SubscribeDTO;

public interface CollectionService {

	public int insertCollection(SubscribeDTO subscribeDTO) ;
	
	public int deleteCollection(SubscribeDTO subscribeDTO);
	
    public String queryStatus(SubscribeDTO subscribeDTO); 
}
