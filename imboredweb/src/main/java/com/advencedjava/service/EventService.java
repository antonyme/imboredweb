package com.advencedjava.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advencedjava.dao.FakeEventDaoImpl;
import com.advencedjava.entity.Event;

@Service
public class EventService {
	@Autowired
	private FakeEventDaoImpl eventDao;
	
	public Collection<Event> getAllEvents() {
		return this.eventDao.getAllEvents();
	}
}
