package com.advencedjava.entity;

public class User {
	private String fbId;
	private String name;
	
	public User() {}
	
	public User(String fbId, String name) {
		this.fbId = fbId;
		this.name = name;
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
}
