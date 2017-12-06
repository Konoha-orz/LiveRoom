package com.niit.org.bean;

import java.io.Serializable;

public class Category implements Serializable {

	private int id;
	private String categoryname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	
	
}
