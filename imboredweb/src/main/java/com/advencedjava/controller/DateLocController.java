package com.advencedjava.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.advencedjava.api.dto.Datum;
import com.advencedjava.api.dto.SearchResult;
import com.advencedjava.entity.DateTime;
import com.advencedjava.entity.EventInfo;
import com.advencedjava.entity.UserLocation;
import com.advencedjava.util.Util;

@Controller
public class DateLocController {
	
	@SuppressWarnings({ "deprecation", "unused" })
	private DateTime date = new DateTime(new Date(2016, 12, 15));
	private UserLocation userLocation = new UserLocation(43.524360, 5.445613);
	

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
		model.addAttribute("location", new UserLocation());
		return "location";
	}
	
	@PostMapping("/location")
	public String userLocation(@ModelAttribute("location") UserLocation userLocation) {
		this.userLocation = userLocation;
		return "redirect:/events";
	}
	
	@GetMapping("/events")
	public String events(Model model) {
		return "events";
	}
	
	@GetMapping("/events-info")
	public @ResponseBody List<EventInfo> eventsLocation() {
		RestTemplate restTemplate = new RestTemplate();
        SearchResult result = restTemplate.getForObject(
        		Util.buildOpenAgendaURL(userLocation.getLat(), userLocation.getLng()), SearchResult.class);
        
        List<EventInfo> eventsInfo = new ArrayList<>(); 
        for(Datum event : result.getData()) {
        	EventInfo eventInfo = new EventInfo();
        	if(eventInfo.fill(event)) {
        		eventsInfo.add(eventInfo);
        	}
        }
        return eventsInfo;
	}
	
}
