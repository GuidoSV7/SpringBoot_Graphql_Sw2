package com.graphl.flight.services;

import com.graphl.flight.entities.Accomodation;

import java.util.List;

public interface IAccomodationService {

    Accomodation findById(String id);

    List<Accomodation> findAllAccomodations();

    void createAccomodation(Accomodation bed);

    void deleteById(String id);

    Accomodation updateAccomodation(String id, Accomodation bed);

    List<Accomodation> findAccomodationsByUserId(String idUser);
}
