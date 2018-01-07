package com.niit.org.dto;

import java.io.Serializable;

public class LiveRoomDTO implements Serializable {
   private int id;
   private String title;
   private String dscp;
   private int userid;
   private String categoryname;
   private String rtmpurl;
   private int status;
   private String seriescode;
   private String username;
   
   
public String getSeriescode() {
	return seriescode;
}
public void setSeriescode(String seriescode) {
	this.seriescode = seriescode;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDscp() {
	return dscp;
}
public void setDscp(String dscp) {
	this.dscp = dscp;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public String getRtmpurl() {
	return rtmpurl;
}
public void setRtmpurl(String rtmpurl) {
	this.rtmpurl = rtmpurl;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}

