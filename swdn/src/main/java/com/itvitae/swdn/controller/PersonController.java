package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.NawDto;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;


    //READ
    @GetMapping("/{id}")
    public PersonGetDto getPersonById(@PathVariable(value = "id") long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/all")
    public Iterable<PersonGetDto> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/gettrainees/{id}")
    public Iterable<PersonGetDto> getTrainees(@PathVariable(value = "id") long id) {
        return personService.getTrainees(id);
    }

    @GetMapping("/getsubordinates/{id}")
    public Iterable<PersonGetDto> getSubordinates(@PathVariable(value = "id") long id) {
        return personService.getSubordinates(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public void updatePersonById(@PathVariable(value = "id") long id, @RequestBody NawDto nawDto) {
        personService.updatePersonById(id, nawDto);
    }

    @PutMapping("/setpeople/{id}/coach/{coachid}/manager/{managerid}")
    public void setPeople(@PathVariable(value = "id") long id, @PathVariable(value = "coachid") long coachid, @PathVariable(value = "managerid") long managerid) {
        personService.setPeople(id, coachid, managerid);
    }
}
