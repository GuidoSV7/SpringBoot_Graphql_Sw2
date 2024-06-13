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
        if (offer.getTitle() != null) {
            offerToUpdate.setTitle(offer.getTitle());
        }
        if (offer.getImageUrl() != null) {
            offerToUpdate.setImageUrl(offer.getImageUrl());
        }
        if (offer.getTypeRoom() != null) {
            offerToUpdate.setTypeRoom(offer.getTypeRoom());
        }
        if (offer.getBeds() != null) {
            offerToUpdate.setBeds(offer.getBeds());
        }
        if (offer.getDescriptionServices() != null) {
            offerToUpdate.setDescriptionServices(offer.getDescriptionServices());
        }
        if (offer.getPrice() != null) {
            offerToUpdate.setPrice(offer.getPrice());
        }
        if (offer.getState() != null) {
            offerToUpdate.setState(offer.getState());
        }
        if (offer.getIdAccomodation() != null) {
            offerToUpdate.setIdAccomodation(offer.getIdAccomodation());
        }
        if (offer.getDiscount() != null) {
            offerToUpdate.setDiscount(offer.getDiscount());
        }


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
