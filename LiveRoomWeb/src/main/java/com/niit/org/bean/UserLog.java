package com.niit.org.bean;

import java.sql.Timestamp;

public class UserLog {

	private int id;

	private String description;

	private Timestamp logtime;

	private int account_id;

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public Timestamp getLogtime() {

		return logtime;

	}

	public void setLogtime(Timestamp logtime) {

		this.logtime = logtime;

	}

	public int getAccount_id() {

		return account_id;

	}

	public void setAccount_id(int account_id) {

		this.account_id = account_id;

	}

	
}
