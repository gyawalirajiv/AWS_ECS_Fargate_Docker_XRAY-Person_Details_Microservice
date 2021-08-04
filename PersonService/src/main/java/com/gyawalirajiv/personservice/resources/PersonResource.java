package com.gyawalirajiv.personservice.resources;

import com.gyawalirajiv.personservice.models.Person;
import com.gyawalirajiv.personservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @GetMapping("/person")
    public List<Person> getAllPeople(){
        return personService.getAll();
    }

}
