package com.niit.org.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.niit.org.bean.LiveRoom;
import com.niit.org.dto.LiveRoomDTO;

public interface ILiveRoomService {

	public List<LiveRoomDTO> queryAllLiveRoom();

	public List<LiveRoomDTO> searchByKey(@Param(value = "key") String key);

	public List<LiveRoomDTO> queryRoomById(Integer roomId);
	
	//获取某类型直播间全部数据
	public List<LiveRoomDTO> getListByType(@Param(value="type")String type);
	
	//获取某类型直播间中前num个数据
	public List<LiveRoomDTO> getListByTypeInNum(@Param(value="type")String type,@Param(value="num")int num);
	
	public List<LiveRoomDTO> getHotList();
	
	//获取已关注的直播间列表
	public List<LiveRoomDTO> getCollectListByUserId(@Param(value="userId")String userId);
	
	public List<LiveRoom> getLiveroom(int liveroomid);
	public List<LiveRoom> getAll();
	public List<LiveRoom> getLiveroomByUserid(int userid);
	public void createLiveroom(LiveRoom liveroom);
	public List<LiveRoomDTO> queryLiveRoomById(int userid);
	public void updateLiveroom(LiveRoom liveroom);
	public void openLiveroom(int userid);
	public void closeLiveroom(int userid);
	
}
