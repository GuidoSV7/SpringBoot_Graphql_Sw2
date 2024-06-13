package com.graphl.flight.services.implementation;

import com.graphl.flight.entities.OpinionForm;
import com.graphl.flight.persistence.IOpinionFormDAO;
import com.graphl.flight.services.IBedService;
import com.graphl.flight.services.IOpinionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionFormService implements IOpinionFormService {

    @Autowired
    private IOpinionFormDAO opinionFormDAO;
    @Override
    public OpinionForm findById(String id) {
        return opinionFormDAO.findById(id).orElseThrow();
    }

    @Override
    public List<OpinionForm> findAllOpinionForms() {
        return (List<OpinionForm>) opinionFormDAO.findAll();
    }

    @Override
    public void createOpinionForm(OpinionForm opinionForm) {
        opinionFormDAO.save(opinionForm);

    }

    @Override
    public void deleteById(String id) {
        opinionFormDAO.deleteById(id);
    }

    @Override
    public OpinionForm updateOpinionForm(String id, OpinionForm opinionForm) {
        OpinionForm opinionFormToUpdate = opinionFormDAO.findById(id).orElseThrow();
        opinionFormToUpdate.setState(opinionForm.getState());
        opinionFormToUpdate.setOrigin(opinionForm.getOrigin());
        opinionFormToUpdate.setDestination(opinionForm.getDestination());
        opinionFormToUpdate.setTripOpinion(opinionForm.getTripOpinion());
        opinionFormToUpdate.setDestinyOpinion(opinionForm.getDestinyOpinion());
        opinionFormToUpdate.setAccommodationName(opinionForm.getAccommodationName());
        opinionFormToUpdate.setReasonTrip(opinionForm.getReasonTrip());
        opinionFormDAO.save(opinionFormToUpdate);
        return opinionFormToUpdate;

    }
}
