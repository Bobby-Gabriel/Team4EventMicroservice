package com.team4.project;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsMongoService implements EventsService {

	@Autowired
	EventsMongoRepository repo;
	
	@Override
	public Iterable<Event> getEvents() {
		return repo.findAll();
	}

	@Override
	public Optional<Event> getEventById(String id) {
		return repo.findById(id);
	}

	@Override
	public void deleteEvent(Event event) {
		repo.delete(event);
	}

	@Override
	public void deleteEventById(String id) {
		repo.deleteById(id);
	}
	
	@Override
	public void addEvent(Event e) {
		repo.save(e);
	}

	@Override
	public void updateEvent(Event e, String id) {
		repo.save(e);
	}

}
