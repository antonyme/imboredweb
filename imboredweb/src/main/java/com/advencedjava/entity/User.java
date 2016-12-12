package com.advencedjava.entity;

public class User {
	private String fbId;
	private String name;
	private String picture;
	
	public User() {}
	
	public User(String fbId, String name, String picture) {
		this.fbId = fbId;
		this.name = name;
		this.picture = picture;
	}
	
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
