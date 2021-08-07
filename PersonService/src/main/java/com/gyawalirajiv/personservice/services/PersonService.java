package com.gyawalirajiv.personservice.services;

import com.gyawalirajiv.personservice.dtos.PersonDTO;
import com.gyawalirajiv.personservice.dtos.PersonDetailsDTO;
import com.gyawalirajiv.personservice.models.Person;
import com.gyawalirajiv.personservice.models.PersonDetails;
import com.gyawalirajiv.personservice.repository.PersonDetailsRepository;
import com.gyawalirajiv.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDetailsRepository personDetailsRepository;

    public PersonDTO getPerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such Person exists!"));
        PersonDetails personDetails = person.getPersonDetails();

        PersonDTO personDTO = new PersonDTO(
                person.getId(),
                person.getName(),
                person.getAge(),
                new PersonDetailsDTO(
                        personDetails.getId(),
                        personDetails.getPhoneNumber(),
                        personDetails.getAddress()
                ));
        return personDTO;
    }

    @Transactional
    public Person save(Person person) {
        PersonDetails personDetails = person.getPersonDetails();
        person = personRepository.save(person);
        personDetails.setPerson(person);
        personDetailsRepository.save(personDetails);
        return person;
    }

    public List<PersonDTO> getAll() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(person -> new PersonDTO(person.getId(), person.getName(), person.getAge(), null))
                .collect(Collectors.toList());
    }
}
