package com.graphl.flight.persistence;


import com.graphl.flight.entities.Accomodation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAccomodationDAO extends MongoRepository<Accomodation, String> {
}
