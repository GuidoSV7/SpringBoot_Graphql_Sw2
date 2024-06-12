package com.graphl.flight.controller;

import com.graphl.flight.entities.Accomodation;
import com.graphl.flight.graphql.InputAccomodation;
import com.graphl.flight.services.IAccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLAccomodationController {
    @Autowired
    private IAccomodationService accomodationService;

    @QueryMapping(name= "findAccomodationById")
    public Accomodation findAccomodationById(@Argument(name = "accomodationId") String id){
        String accomodationId = id;
        return accomodationService.findById(accomodationId);
    }


    @QueryMapping(name= "findAllAccomodations")
    public List<Accomodation> findAllAccomodations(){
        return accomodationService.findAllAccomodations();
    }

    @MutationMapping
    public Accomodation createAccomodation(@Argument InputAccomodation inputAccomodation){
        Accomodation accomodation = new Accomodation();
        accomodation.setDescription(inputAccomodation.getDescription());
        accomodation.setOwner(inputAccomodation.getOwner());
        accomodation.setSchedule(inputAccomodation.getSchedule());
        accomodation.setPage(inputAccomodation.getPage());
        accomodation.setQuantity(inputAccomodation.getQuantity());
        accomodation.setDescription_services(inputAccomodation.getDescription_services());
        accomodation.setAttention_number(inputAccomodation.getAttention_number());
        accomodation.setImageUrl(inputAccomodation.getImageUrl());
        accomodation.setTypeRoom(inputAccomodation.getTypeRoom());



        accomodationService.createAccomodation(accomodation);
        return accomodation;
    }

    @MutationMapping()
    public String deleteAccomodationById(@Argument(name = "accomodationId") String id){
        accomodationService.deleteById(id);
        return "Accomodation with id: " + id + " has been deleted";
    }

    @MutationMapping
    public Accomodation updateAccomodation(@Argument(name = "accomodationId") String id, @Argument InputAccomodation inputAccomodation){
        Accomodation accomodation = new Accomodation();
        accomodation.setDescription(inputAccomodation.getDescription());
        accomodation.setOwner(inputAccomodation.getOwner());
        accomodation.setSchedule(inputAccomodation.getSchedule());
        accomodation.setPage(inputAccomodation.getPage());
        accomodation.setQuantity(inputAccomodation.getQuantity());
        accomodation.setDescription_services(inputAccomodation.getDescription_services());
        accomodation.setAttention_number(inputAccomodation.getAttention_number());
        accomodation.setImageUrl(inputAccomodation.getImageUrl());
        accomodation.setTypeRoom(inputAccomodation.getTypeRoom());


        return accomodationService.updateAccomodation(id, accomodation);
    }

}
