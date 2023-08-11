package com.team4.project;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MockEventService implements EventsService {
	
	static ArrayList<Event> events = new ArrayList<Event>();
	
	static int idx;

	static {  
		Event e1 = new Event("AB313", "A cool event", "EventOne");
		e1.setId(0);
		
		Event e2 = new Event("VMA13", "A cooler event", "EventTwo");
		e2.setId(1);
		
		Event e3 = new Event("VM431", "A super cool event", "EventThree");
		e3.setId(2);
		
		events.add(e1);
		events.add(e2);
		events.add(e3);
		
		idx = 3;
	}

	@Override
	public Iterable<Event> getEvents() {
		return events;
	}

	@Override
	public Optional<Event> getEventById(long id) {
		for (Event event : events) {
			if (event.getId() == id) {
				return Optional.of(event);
			}
		}
		return Optional.empty();
	}

	@Override
	public void deleteEventById(long id) {
		for (Event event : events) {
			if (event.getId() == id) {
				events.remove(event);
			}
		}
		
	}

	@Override
	public Event addEvent(Event e) {
		e.setId((long)(idx));
		idx++;
		events.add(e);
		return e;
	}

	@Override
	public void updateEvent(Event e, long id) {
		
		for (int i = 0; i < events.size(); i++) {
			Event event = events.get(i);
			if (event.getId() == id) {
				events.set(i, e);
				return;
			}
		}
		
		addEvent(e);
		
	}

	@Override
	public void deleteEvent(Event event) {
		events.remove(event);
		
	}

}
