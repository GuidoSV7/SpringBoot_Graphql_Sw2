package com.graphl.flight.persistence;

import com.graphl.flight.entities.Accomodation;
import com.graphl.flight.entities.Bed;
import com.graphl.flight.entities.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOfferDAO extends MongoRepository<Offer, String> {
    List<Offer> findByIdAccomodation(String idAccomodation);
}
