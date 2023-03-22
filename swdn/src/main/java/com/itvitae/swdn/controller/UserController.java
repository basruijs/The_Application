package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.LoginRequest;
import com.itvitae.swdn.dto.PasswordChange;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController implements UserApi {
    @Autowired
    UserService userService;

    //CREATE
    @Override
    public void newUser(@RequestBody UserPostDto userPostDto, @PathVariable(value = "roleid") long roleid) {
        userService.newUser(userPostDto, roleid);
    }

    @Override
    public PersonGetDto authenticateUser(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    //UPDATE
    @Override
    public void updatePassword(@RequestBody PasswordChange newCredentials) {
        userService.updatePassword(newCredentials);
    }
}
