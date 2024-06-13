package com.graphl.flight.controller;

import com.graphl.flight.entities.OpinionForm;
import com.graphl.flight.graphql.InputOpinionForm;
import com.graphl.flight.services.IOpinionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class GraphQLOpinionFormController {

    @Autowired
    private IOpinionFormService opinionFormService;

    @QueryMapping(name= "findOpinionFormById")
    public OpinionForm findOpinionFormById(@Argument(name = "opinionFormId") String id){
        String opinionFormId = id;
        return opinionFormService.findById(opinionFormId);
    }


    @QueryMapping(name= "findAllOpinionForms")
    public List<OpinionForm> findAllOpinionForms(){
        return opinionFormService.findAllOpinionForms();
    }

    @MutationMapping
    public OpinionForm createOpinionForm(@Argument InputOpinionForm inputOpinionForm){
        OpinionForm opinionForm = new OpinionForm();
        opinionForm.setState(inputOpinionForm.getState());
        opinionForm.setOrigin(inputOpinionForm.getOrigin());
        opinionForm.setDestination(inputOpinionForm.getDestination());
        opinionForm.setTripOpinion(inputOpinionForm.getTripOpinion());
        opinionForm.setDestinyOpinion(inputOpinionForm.getDestinyOpinion());
        opinionForm.setAccommodationName(inputOpinionForm.getAccommodationName());
        opinionForm.setReasonTrip(inputOpinionForm.getReasonTrip());
        opinionFormService.createOpinionForm(opinionForm);
        return opinionForm;
    }

    @MutationMapping()
    public String deleteOpinionFormById(@Argument(name = "opinionFormId") String id){
        opinionFormService.deleteById(id);
        return "OpinionForm with id: " + id + " has been deleted";
    }

    @MutationMapping
    public OpinionForm updateOpinionForm(@Argument(name = "opinionFormId") String id, @Argument InputOpinionForm inputOpinionForm){
        OpinionForm opinionForm = new OpinionForm();
        opinionForm.setState(inputOpinionForm.getState());
        opinionForm.setOrigin(inputOpinionForm.getOrigin());
        opinionForm.setDestination(inputOpinionForm.getDestination());
        opinionForm.setTripOpinion(inputOpinionForm.getTripOpinion());
        opinionForm.setDestinyOpinion(inputOpinionForm.getDestinyOpinion());
        opinionForm.setAccommodationName(inputOpinionForm.getAccommodationName());
        opinionForm.setReasonTrip(inputOpinionForm.getReasonTrip());

        
        return opinionFormService.updateOpinionForm(id, opinionForm);
    }
}
