package com.team4.project;

import java.util.Optional;

public interface EventsService {

	Iterable<Event> getEvents();

	Optional<Event> getEventById(long id);
	
	Event addEvent(Event e);
	
	void updateEvent(Event e, long eventId);

	void deleteEvent(Event event);

	void deleteEventById(long id);
}
