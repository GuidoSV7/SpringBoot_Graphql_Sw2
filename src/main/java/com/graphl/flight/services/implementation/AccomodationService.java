package com.graphl.flight.services.implementation;

import com.graphl.flight.entities.Accomodation;
import com.graphl.flight.persistence.IAccomodationDAO;
import com.graphl.flight.persistence.IAccomodationDAO;
import com.graphl.flight.services.IAccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationService implements IAccomodationService {

    @Autowired
    private IAccomodationDAO accomodationDAO;
    @Override
    public Accomodation findById(String id) {
        return accomodationDAO.findById(id).orElseThrow();
    }

    @Override
    public List<Accomodation> findAllAccomodations() {
        return (List<Accomodation>) accomodationDAO.findAll();
    }

    @Override
    public void createAccomodation(Accomodation bed) {
        accomodationDAO.save(bed);

    }

    @Override
    public void deleteById(String id) {
        accomodationDAO.deleteById(id);
    }

    @Override
    public Accomodation updateAccomodation(String id, Accomodation bed) {
        Accomodation accomodationToUpdate = accomodationDAO.findById(id).orElseThrow();
        accomodationToUpdate.setAttention_number(bed.getAttention_number());
        accomodationToUpdate.setOwner(bed.getOwner());
        accomodationToUpdate.setDescription(bed.getDescription());
        accomodationToUpdate.setSchedule(bed.getSchedule());
        accomodationToUpdate.setPage(bed.getPage());
        accomodationToUpdate.setQuantity(bed.getQuantity());
        accomodationToUpdate.setDescription_services(bed.getDescription_services());
        accomodationToUpdate.setImageUrl(bed.getImageUrl());
        


        accomodationDAO.save(accomodationToUpdate);
        return accomodationToUpdate;

    }
}
