package com.advencedjava.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.advencedjava.entity.EventInfo;
import com.advencedjava.entity.User;

public class GroupController {
	EventInfo eventInfo;
	UUID uid;
	List<User> userList = new ArrayList<>();
	
	public GroupController() {}
	
	public GroupController(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public List<User> getUsers() {
		return userList;
	}

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}
}
