package com.graphl.flight.persistence;

import com.graphl.flight.entities.Accomodation;
import com.graphl.flight.entities.OpinionForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOpinionFormDAO extends MongoRepository<OpinionForm, String> {
}
