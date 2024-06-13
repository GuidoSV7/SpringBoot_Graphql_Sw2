package com.graphl.flight.services.implementation;

import com.graphl.flight.entities.Offer;
import com.graphl.flight.entities.Offer;
import com.graphl.flight.persistence.IOfferDAO;
import com.graphl.flight.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfferService implements IOfferService {

    @Autowired
    private IOfferDAO offerDAO;
    @Override
    public Offer findById(String id) {
        return offerDAO.findById(id).orElseThrow();
    }

    @Override
    public List<Offer> findAllOffers() {
        return (List<Offer>) offerDAO.findAll();
    }

    @Override
    public void createOffer(Offer offer) {
        offerDAO.save(offer);

    }

    @Override
    public void deleteById(String id) {
        offerDAO.deleteById(id);
    }

    @Override
    public Offer updateOffer(String id, Offer offer) {
        Offer offerToUpdate = offerDAO.findById(id).orElseThrow();

        offerDAO.save(offerToUpdate);
        return offerToUpdate;

    }

    @Override
    public List<Offer> findOffersByAccomodationId(String idAccomodation) {

        List<Offer> offers = offerDAO.findByIdAccomodation(idAccomodation);
        if (offers.isEmpty()) {
            throw new RuntimeException("No offers found for user with id: " + idAccomodation);

        }
        return offers;
    }
}
