package com.advencedjava.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.advencedjava.api.dto.SearchResult;
import com.advencedjava.entity.DateTime;
import com.advencedjava.entity.Location;
import com.advencedjava.util.Util;

@Controller
public class DateLocController {
	
	@SuppressWarnings("deprecation")
	private DateTime date = new DateTime(new Date(2016, 12, 15));
	private Location location = new Location(43.524360, 5.445613);
	

	@GetMapping("/home")
	public String getHome(Model m) {
		m.addAttribute("msg", "Hi!");
		return "home";
	}

	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", new DateTime());
		return "date";
	}
	
	@PostMapping("/date")
	public String date(@ModelAttribute("date") DateTime date) {
		this.date = date;
		return "redirect:/location";
	}

	@GetMapping("/location")
	public String location(Model model) {
		model.addAttribute("location", new Location());
		return "location";
	}
	
	@PostMapping("/location")
	public String location(@ModelAttribute("location") Location location) {
		this.location = location;
		return "redirect:/events";
	}
	
	@GetMapping("/events")
	public String events(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        SearchResult result = restTemplate.getForObject(
        		Util.buildOpenAgendaURL(location.getLat(), location.getLng()), SearchResult.class);
        System.out.println(result.getData().get(0).getTitle().getFr() + date.getDate().toString());
		return "events";
	}
	
	
}
