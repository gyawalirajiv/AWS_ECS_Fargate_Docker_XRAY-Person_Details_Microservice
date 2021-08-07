package com.gyawalirajiv.personservice.resources;

import com.gyawalirajiv.personservice.dtos.PersonDTO;
import com.gyawalirajiv.personservice.models.Person;
import com.gyawalirajiv.personservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    @Autowired
    PersonService personService;

    /**
     * A POST mapping that creates a Person with their Person Details
     * Sample JSON Body
     * {
     *   "name": "Rajiv",
     *   "age": 28,
     *   "personDetails": {
     *   	"phoneNumber": +977 123456789,
     *     "address": "New YOrk"
     *   }
     * }
     *
     * @param person - the JSON input data
     * @return a DTO of the created Person Entity.
     */
    @PostMapping("/person")
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    /**
     * A GET mapping that returns the Person with the specific id, along with its Person Details
     *
     * @param id - ID of the Person of which we need Data
     * @return a DTO of the specified Person Entity
     */
    @GetMapping("/person/{id}")
    public PersonDTO getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    /**
     * A GET mapping that returns all the People without their Person Details
     *
     * @return a List of Person without Person Details
     */
    @GetMapping("/person")
    public List<PersonDTO> getAllPeople(){
        return personService.getAll();
    }

}
