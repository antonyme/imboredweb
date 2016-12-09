package com.advencedjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advencedjava.entity.Date;
import com.advencedjava.entity.Location;

@Controller
public class DateLocController {

	@GetMapping("/home")
	public String getHome(Model m) {
		m.addAttribute("msg", "Hi!");
		return "home";
	}

	@GetMapping(value="/date")
	public String date(Model model) {
		model.addAttribute("date", new Date());
		return "date";
	}
	
	@PostMapping(value="/date")
	public String date(@ModelAttribute("date") Date date) {
		System.out.println(date.getContent());
		return "redirect:/location";
	}

	@GetMapping("/location")
	public String location(Model model) {
		model.addAttribute("location", new Location());
		return "location";
	}
	
	@PostMapping
	public String location(@ModelAttribute("location") Location location) {
		System.out.println(location.getLat());
		return "redirect:/home";
	}
}
