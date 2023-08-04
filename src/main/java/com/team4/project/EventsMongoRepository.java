package com.team4.project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventsMongoRepository extends MongoRepository<Event, String> {

}
