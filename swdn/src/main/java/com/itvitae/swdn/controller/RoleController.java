package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //READ
    @GetMapping("/trainee/all")
    public Iterable<PersonGetDto> getAllTrainees() {
        return roleService.getAllOfRole("TRAINEE");
    }

    @GetMapping("/coach/all")
    public Iterable<PersonGetDto> getAllCoaches() {
        return roleService.getAllOfRole("COACH");
    }

    @GetMapping("/manager/all")
    public Iterable<PersonGetDto> getAllManagers() {
        return roleService.getAllOfRole("MANAGER");
    }

}
