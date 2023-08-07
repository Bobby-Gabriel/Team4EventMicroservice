package com.team4.project;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsValet implements EventsService {

	@Autowired
	EventsRepository repo;
	
	@Override
	public Iterable<Event> getEvents() {
		return repo.findAll();
	}

	@Override
	public Optional<Event> getEventById(long id) {
		return repo.findById(id);
	}

	@Override
	public void deleteEvent(Event event) {
		repo.delete(event);
	}

	@Override
	public void deleteEventById(long id) {
		repo.deleteById(id);
	}
	
	@Override
	public Event addEvent(Event e) {
		return repo.save(e);
	}

	@Override
	public void updateEvent(Event e, long id) {
		repo.save(e);
	}

}
