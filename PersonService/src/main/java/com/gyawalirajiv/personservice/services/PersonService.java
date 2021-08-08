package com.gyawalirajiv.personservice.services;

import com.gyawalirajiv.personservice.models.Person;
import com.gyawalirajiv.personservice.models.PersonDetails;
import com.gyawalirajiv.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${person.details.service.uri}")
    private String personDetailsServiceURI;

    public Person getPerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such Person exists!"));
        PersonDetails personDetails = restTemplate.getForObject(personDetailsServiceURI + "/api/personDetails/" + person.getId(), PersonDetails.class);

        person.setPersonDetails(personDetails);
        return person;
    }

    @Transactional
    public Person save(Person person) {
        person = personRepository.save(person);
        PersonDetails personDetails = person.getPersonDetails();
        personDetails.setPersonId(person.getId());

        personDetails = restTemplate.postForObject(personDetailsServiceURI + "/api/personDetails", personDetails, PersonDetails.class);
        person.setPersonDetails(personDetails);
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
