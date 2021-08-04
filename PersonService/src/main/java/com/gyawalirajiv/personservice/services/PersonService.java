package com.gyawalirajiv.personservice.services;

import com.gyawalirajiv.personservice.models.Person;
import com.gyawalirajiv.personservice.models.PersonDetails;
import com.gyawalirajiv.personservice.repository.PersonDetailsRepository;
import com.gyawalirajiv.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDetailsRepository personDetailsRepository;

    public Person getPerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such Person exists!"));
        return person;
    }

    @Transactional
    public Person save(Person person) {
        PersonDetails personDetails = person.getPersonDetails();
        person = personRepository.save(person);
        personDetails.setPerson(person);
        personDetailsRepository.save(personDetails);
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
