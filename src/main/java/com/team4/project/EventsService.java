package com.team4.project;

import java.util.Optional;

public interface EventsService {

	Iterable<Event> getEvents();

	Optional<Event> getEventById(String id);
	
	void addEvent(Event e);
	
	void updateEvent(Event e, String eventId);

	void deleteEvent(Event event);

	void deleteEventById(String id);
}
