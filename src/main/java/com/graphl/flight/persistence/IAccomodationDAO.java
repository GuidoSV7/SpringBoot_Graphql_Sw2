package com.graphl.flight.persistence;


import com.graphl.flight.entities.Accomodation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IAccomodationDAO extends MongoRepository<Accomodation, String> {
    List<Accomodation> findByIdUser(String idUser);
}
