package com.niit.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.niit.org.dto.LiveRoomDTO;
import com.niit.org.dto.SubscribeDTO;
import com.niit.org.mapper.CollectionMapper;
import com.niit.org.service.CollectionService;

@Service("CollectionService")
public class CollectionServiceImpl implements CollectionService{

	@Resource 
	CollectionMapper collectionMapper;
	
	@Override
	public int insertCollection(SubscribeDTO subscribeDTO) {
		int result=collectionMapper.insertCollect(subscribeDTO);
		return result;
	}

	@Override
	public int deleteCollection(SubscribeDTO subscribeDTO) {
		int result=collectionMapper.deleteCollect(subscribeDTO);
		return result;
	}

	@Override
	public String queryStatus(SubscribeDTO subscribeDTO) {
		
		return collectionMapper.queryStatus(subscribeDTO);
	}

	@Override
	public List<LiveRoomDTO> getMyCollect(Integer id) {
		
		return collectionMapper.getMyList(id);
	}

}
