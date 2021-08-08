package com.gyawalirajiv.persondetailsservice.services;

import com.gyawalirajiv.persondetailsservice.models.PersonDetails;
import com.gyawalirajiv.persondetailsservice.repository.PersonDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService {

    @Autowired
    private PersonDetailsRepository personDetailsRepository;


    public PersonDetails getPersonDetailsOfPerson(Long id) {
        return personDetailsRepository.findByPersonId(id).orElseThrow(() -> new RuntimeException("No Such Person Exists!"));
    }

    public PersonDetails save(PersonDetails personDetails) {
        return personDetailsRepository.save(personDetails);
    }
}
