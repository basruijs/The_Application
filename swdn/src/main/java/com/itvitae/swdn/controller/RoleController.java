package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RoleController implements RoleApi {
    @Autowired
    RoleService roleService;

    //READ
    @Override
    public Iterable<PersonGetDto> getAllTrainees() {
        return roleService.getAllOfRole("TRAINEE");
    }

    @Override
    public Iterable<PersonGetDto> getAllCoaches() {
        return roleService.getAllOfRole("COACH");
    }

    @Override
    public Iterable<PersonGetDto> getAllManagers() {
        return roleService.getAllOfRole("MANAGER");
    }

}
