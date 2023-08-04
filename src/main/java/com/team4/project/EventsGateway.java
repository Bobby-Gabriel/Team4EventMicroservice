package com.team4.project;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("/gateway/events")
@RestController
@CrossOrigin
public class EventsGateway {

	static final String JSON = "application/json";

	@Autowired
	EventsService eventsService;

	
	@GetMapping
	public Iterable<Event> getAllEvents(HttpServletResponse response) {
		
		response.setStatus(HttpServletResponse.SC_OK);
		return eventsService.getEvents();
	}
	
	
	// GET a customer by their place in the list
	@GetMapping("/{id}")
	public Optional<Event> getOneSingleEvent(@PathVariable String id, HttpServletResponse response) {
		
		response.setStatus(HttpServletResponse.SC_OK);
		return eventsService.getEventById(id);
			
	}
	
	
	// POST a new event to the list
	@PostMapping(consumes = JSON, produces = JSON)
	public ResponseEntity<?> addEvent(@RequestBody Event e, HttpServletResponse response) {
		Event postedEvent = eventsService.addEvent(e);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<>(postedEvent, headers, HttpStatus.OK);
			
	}
	
	
	@PutMapping("/{eventId}")
	public ResponseEntity<?> putCustomer(@RequestBody Event newEvent, @PathVariable String eventId) {
		if (!(newEvent.getId().equals(eventId))) {
			return ResponseEntity.badRequest().build();
		}
		eventsService.updateEvent(newEvent, eventId);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> responseEntity = ResponseEntity.created(location).build();
		return responseEntity;
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable String id){
	    
		eventsService.deleteEventById(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteEvent(Event e){
	    
		eventsService.deleteEvent(e);
		return ResponseEntity.ok().build();
	}
}
