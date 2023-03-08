package com.itvitae.swdn.controller;

import com.itvitae.swdn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;
}
