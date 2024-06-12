package com.graphl.flight.persistence;

import com.graphl.flight.entities.Bed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface IBedDAO extends MongoRepository<Bed, String> {
}
