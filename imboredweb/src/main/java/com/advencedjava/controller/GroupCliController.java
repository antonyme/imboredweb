package com.advencedjava.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.advencedjava.entity.User;


@Controller
@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GroupCliController {
	@Autowired
	private GroupsManagerController manager;
	private GroupController group;
	@SuppressWarnings("unused")
	private User user;
	
	@GetMapping("/group/{groupUid}")
	public String connect(@PathVariable UUID groupUid, Model model) {
		group = manager.getGroup(groupUid);
		model.addAttribute("user", new User());
		return "group-home";
	}
	
	@PostMapping("/group/home")
	public String postConnect(@ModelAttribute User user) {
		this.user = user;
		group.addUser(user);
		return "redirect:/group";
	}
	
	@GetMapping("/group/{groupUid}/create")
	public String joinEvent(@PathVariable UUID groupUid, @ModelAttribute("user") User user) {
		group = manager.getGroup(groupUid);
		this.user = user;
		group.addUser(user);
		return "redirect:/group";
	}
	
	@GetMapping("/group")
	public String group(Model model) {
		System.out.println("user list size " + group.getUsers().size());
		model.addAttribute("users", group.getUsers());
		model.addAttribute("url", "http://localhost:8080/group/" + group.getUid().toString());
		model.addAttribute("event", group.getEventInfo());
		return "group";
	}
}
