package com.advencedjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advencedjava.entity.Date;

@Controller
public class DateController {
	@GetMapping(value="/date")
	public String date(Model model) {
		model.addAttribute("date", new Date());
		return "date";
	}
	
	@PostMapping(value="/date")
	public String date(@ModelAttribute("date") Date date) {
		return "home";
	}
}
