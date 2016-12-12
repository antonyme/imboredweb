package com.advencedjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.advencedjava.entity.User;

@Controller
public class TestController {
	private List<User> users = new ArrayList<>();
	
	@GetMapping("/test")
	public String test(Model model) {
		users.add(new User("13424", "ZDOINicoein iozjfo", "url"));
		model.addAttribute("users", users);
		model.addAttribute("url", "http://localhost:8080/group");
		return "test";
	}
	
}
