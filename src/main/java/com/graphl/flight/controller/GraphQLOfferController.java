package com.graphl.flight.controller;

import com.graphl.flight.entities.Offer;
import com.graphl.flight.graphql.InputOffer;
import com.graphl.flight.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLOfferController {

    @Autowired
    private IOfferService offerService;

    @QueryMapping(name= "findOfferById")
    public Offer findOfferById(@Argument(name = "offerId") String id){
        String offerId = id;
        return offerService.findById(offerId);
    }



    @QueryMapping(name= "findAllOffers")
    public List<Offer> findAllOffers(){
        return offerService.findAllOffers();
    }



    @MutationMapping
    public Offer createOffer(@Argument InputOffer inputOffer){
        Offer offer = new Offer();
        offer.setTitle(inputOffer.getTitle());
        offer.setImageUrl(inputOffer.getImageUrl());
        offer.setTypeRoom(inputOffer.getTypeRoom());
        offer.setBeds(inputOffer.getBeds());
        offer.setDescriptionServices(inputOffer.getDescriptionServices());
        offer.setPrice(inputOffer.getPrice());
        offer.setState(inputOffer.getState());
        offer.setIdAccomodation(inputOffer.getIdAccomodation());
        offer.setDiscount(inputOffer.getDiscount());

        offerService.createOffer(offer);
        return offer;
    }

    @MutationMapping()
    public String deleteOfferById(@Argument(name = "offerId") String id){
        offerService.deleteById(id);
        return "Offer with id: " + id + " has been deleted";
    }

    @MutationMapping
    public Offer updateOffer(@Argument(name = "offerId") String id, @Argument InputOffer inputOffer){
        Offer offer = new Offer();
        if (inputOffer.getBeds() != null) {
            offer.setBeds(inputOffer.getBeds());
        }
        if (inputOffer.getDescriptionServices() != null) {
            offer.setDescriptionServices(inputOffer.getDescriptionServices());
        }
        if (inputOffer.getDiscount() != null) {
            offer.setDiscount(inputOffer.getDiscount());
        }
        if (inputOffer.getIdAccomodation() != null) {
            offer.setIdAccomodation(inputOffer.getIdAccomodation());
        }
        if (inputOffer.getImageUrl() != null) {
            offer.setImageUrl(inputOffer.getImageUrl());
        }
        if (inputOffer.getPrice() != null) {
            offer.setPrice(inputOffer.getPrice());
        }
        if (inputOffer.getState() != null) {
            offer.setState(inputOffer.getState());
        }
        if (inputOffer.getTitle() != null) {
            offer.setTitle(inputOffer.getTitle());
        }
        if (inputOffer.getTypeRoom() != null) {
            offer.setTypeRoom(inputOffer.getTypeRoom());
        }

        return offerService.updateOffer(id, offer);
    }

    @QueryMapping(name= "findOffersByAccomodationId")
    public List<Offer> findOffersByUserId(@Argument(name = "accomodationId") String accomodationId){
        return offerService.findOffersByAccomodationId(accomodationId);
    }
    
}
