package com.advencedjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advencedjava.entity.Location;

@Controller
public class LocationController {
	@GetMapping("/location")
	public String location(Model model) {
		model.addAttribute("location", new Location());
		return "location";
	}
	
	@PostMapping
	public String location(@ModelAttribute("location") Location location) {
		System.out.println(location.getLat());
		return "home";
	}
}
