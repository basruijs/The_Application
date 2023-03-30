package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.NawDto;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonController implements PersonApi {
    @Autowired
    PersonService personService;


    //READ
    @Override
    public PersonGetDto getPersonById(long id) {
        return personService.getPersonById(id);
    }

    @Override
    public Iterable<PersonGetDto> getAllPeople() {
        return personService.getAllPeople();
    }

    @Override
    public Iterable<PersonGetDto> getTrainees(long id) {
        return personService.getTrainees(id);
    }

    @Override
    public Iterable<PersonGetDto> getSubordinates(long id) {
        return personService.getSubordinates(id);
    }

    //UPDATE
    @Override
    public void updatePersonById(long id, NawDto nawDto) {
        personService.updatePersonById(id, nawDto);
    }

    @Override
    public void setPeople(long id, long coachid, long managerid) {
        personService.setPeople(id, coachid, managerid);
    }
}
