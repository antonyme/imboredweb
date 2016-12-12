package com.advencedjava.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
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
import com.advencedjava.entity.User;
import com.advencedjava.entity.UserLocation;
import com.advencedjava.util.Util;

@Controller
@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DateLocController {
	
	@Autowired
	private GroupsManagerController manager;
	@SuppressWarnings({ "deprecation" })
	private DateTime date = new DateTime(new Date(2016, 12, 15));
	private UserLocation userLocation = new UserLocation(43.524360, 5.445613);
	private User user = new User("id","name");
	private List<EventInfo> events;
	

	@GetMapping("/home")
	public String getHome(Model m) {
		m.addAttribute("user", new User());
		return "home";
	}
	
	@PostMapping("/home")
	public String postHome(@ModelAttribute User user) {
		this.user = user;
		return "redirect:/date";
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
		model.addAttribute("eventInfo", new EventInfo());
		return "events";
	}
	
	@GetMapping("/events-info")
	public @ResponseBody List<EventInfo> eventsLocation() {
		RestTemplate restTemplate = new RestTemplate();
		String url = Util.buildOpenAgendaURL(userLocation.getLat(), userLocation.getLng(), date.getDate());
        SearchResult result = restTemplate.getForObject(url, SearchResult.class);
        events = new ArrayList<>(); 
        for(Datum event : result.getData()) {
        	EventInfo eventInfo = new EventInfo();
        	if(eventInfo.fill(event)) {
        		events.add(eventInfo);
        	}
        }
        return events;
	}
	
	@PostMapping("/events")
	public String events(@ModelAttribute("eventChoosen") EventInfo eventInfo) {
		for (EventInfo event : events) {
			if(event.getEventUid() == eventInfo.getEventUid()) {
				eventInfo = event;
			}
		}
		UUID groupUid = manager.addGroup(new GroupController(eventInfo));
		return "redirect:/group/" + groupUid + "/user/" + user.getFbId() + "/" + user.getName();
	}
}
