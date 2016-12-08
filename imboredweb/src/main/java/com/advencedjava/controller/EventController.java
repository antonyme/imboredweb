package com.advencedjava.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.advencedjava.entity.Event;
import com.advencedjava.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Event> getAllEvents() {
		return eventService.getAllEvents();
	}
}
