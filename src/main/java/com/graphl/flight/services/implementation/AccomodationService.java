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
    public void createAccomodation(Accomodation accomodation) {
        accomodationDAO.save(accomodation);

    }

    @Override
    public void deleteById(String id) {
        accomodationDAO.deleteById(id);
    }

    @Override
    public Accomodation updateAccomodation(String id, Accomodation accomodation) {
        Accomodation accomodationToUpdate = accomodationDAO.findById(id).orElseThrow();
        accomodationToUpdate.setAttention_number(accomodation.getAttention_number());
        accomodationToUpdate.setOwner(accomodation.getOwner());
        accomodationToUpdate.setDescription(accomodation.getDescription());
        accomodationToUpdate.setSchedule(accomodation.getSchedule());
        accomodationToUpdate.setPage(accomodation.getPage());
        accomodationToUpdate.setQuantity(accomodation.getQuantity());
        accomodationToUpdate.setDescription_services(accomodation.getDescription_services());
        accomodationToUpdate.setImageUrl(accomodation.getImageUrl());
        accomodationToUpdate.setTypeRoom(accomodation.getTypeRoom());
        accomodationToUpdate.setFacebookUrl(accomodation.getFacebookUrl());
        accomodationToUpdate.setInstagramUrl(accomodation.getInstagramUrl());
        accomodationToUpdate.setWebUrl(accomodation.getWebUrl());
        accomodationToUpdate.setStars(accomodation.getStars());
        accomodationToUpdate.setCompany(accomodation.getCompany());
        accomodationToUpdate.setCoordinates(accomodation.getCoordinates());

        


        accomodationDAO.save(accomodationToUpdate);
        return accomodationToUpdate;

    }
}
