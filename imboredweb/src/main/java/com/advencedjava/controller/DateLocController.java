package com.advencedjava.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private DateTime date;
	private UserLocation userLocation = new UserLocation(43.524360, 5.445613);
	private User user = new User("id","name", "https://scontent.xx.fbcdn.net/v/t1.0-1/c15.0.50.50/p50x50/10354686_10150004552801856_220367501106153455_n.jpg?oh=61d2ef0908c4e9ea88e64dcd066685fb&oe=58E9C72F");
	private List<EventInfo> events;
	
	public DateLocController() {
		try {
			date = new DateTime((new SimpleDateFormat("dd/MM/yyyy")).parse("12/12/2016"));
		} catch (ParseException e) {}
		
	}

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
	
	@GetMapping("/no-event")
	public String noEvent(Model model) {
		String msg = "Pas d'évènement trouvé.\nRéessaye peut-être?";
		model.addAttribute("message", msg);
		return "no-event";
	}
	
	@PostMapping("/events")
	public String events(@ModelAttribute("eventChoosen") EventInfo eventInfo,
			final RedirectAttributes attributes) {
		for (EventInfo event : events) {
			if(event.getEventUid() == eventInfo.getEventUid()) {
				eventInfo = event;
			}
		}
		attributes.addFlashAttribute("user", user);
		UUID groupUid = manager.addGroup(new GroupController(eventInfo));
		return "redirect:/group/" + groupUid + "/create";
	}
}
