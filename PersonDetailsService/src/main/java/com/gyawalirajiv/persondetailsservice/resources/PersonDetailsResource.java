package com.gyawalirajiv.persondetailsservice.resources;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.gyawalirajiv.persondetailsservice.models.PersonDetails;
import com.gyawalirajiv.persondetailsservice.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@XRayEnabled
@RequestMapping("/api")
public class PersonDetailsResource {

    @Autowired
    private PersonDetailsService personDetailsService;

    @GetMapping("/personDetails/{personID}")
    public PersonDetails getPersonDetail(@PathVariable Long personID){
        return personDetailsService.getPersonDetailsOfPerson(personID);
    }

    @PostMapping("/personDetails")
    public PersonDetails save(@RequestBody PersonDetails personDetails){
        return personDetailsService.save(personDetails);
    }

}
