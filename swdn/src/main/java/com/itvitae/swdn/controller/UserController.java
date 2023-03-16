package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.LoginRequest;
import com.itvitae.swdn.dto.PasswordChange;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    //CREATE
    @PostMapping("/new/{roleid}")
    public void newUser(@RequestBody UserPostDto userPostDto, @PathVariable(value = "roleid") long roleid) {
        userService.newUser(userPostDto, roleid);
    }

    @PostMapping("/login")
    public PersonGetDto authenticateUser(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    //UPDATE
    @PutMapping("/changepassword")
    public void updatePassword(@RequestBody PasswordChange newCredentials) {
        userService.updatePassword(newCredentials);
    }
}
