package com.advencedjava.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;

@Controller
public class GroupsManagerController {
	Map<UUID, GroupController> groupsMap = new HashMap<>();
	
	public GroupsManagerController() {}
	
	public GroupController getGroup(UUID uid) {
		return groupsMap.get(uid);
	}
	
	public UUID addGroup(GroupController group) {
		UUID newUid = UUID.randomUUID();
		group.setUid(newUid);
		groupsMap.put(newUid, group);
		return newUid;
	}
}
