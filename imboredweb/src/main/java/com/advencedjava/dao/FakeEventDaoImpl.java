package com.advencedjava.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.advencedjava.entity.Event;

@Repository
@Qualifier("fakeData")
public class FakeEventDaoImpl {
	private static Map<Integer, Event> events;
	static {
		events = new HashMap<Integer, Event>() {
			private static final long serialVersionUID = 1L;

			{
				put(1, new Event(1, "patinoire"));
				put(2, new Event(2, "poney"));
				
			}
		};
	}
	
	public Collection<Event> getAllEvents() {
		return FakeEventDaoImpl.events.values();
	}
	
	
}
