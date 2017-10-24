package com.niit.org.bean;

import java.util.List;

public class Account {

    // just test
	//==========================
	private int id;

	private String username;

	private String password;
	
	private List<UserLog> ulList;

	public List<UserLog> getUlList() {
		return ulList;
	}

	public void setUlList(List<UserLog> ulList) {
		this.ulList = ulList;
	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	

}