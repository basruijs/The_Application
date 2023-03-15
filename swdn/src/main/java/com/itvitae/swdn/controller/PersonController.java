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

    //UPDATE
    @PutMapping("/update/{id}")
    public void updatePersonById(@PathVariable(value = "id") long id, @RequestBody NawDto nawDto) {
        personService.updatePersonById(id, nawDto);
    }
}
