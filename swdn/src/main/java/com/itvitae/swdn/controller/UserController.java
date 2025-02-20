package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.*;
import com.itvitae.swdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController implements UserApi {
    @Autowired
    UserService userService;

    //CREATE
    @Override
    public void newUser(UserPostDto userPostDto, long roleid) {
        userService.newUser(userPostDto, roleid);
    }

    @Override
    public PersonGetDto authenticateUser(LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    //UPDATE
    @Override
    public void updatePassword(PasswordChange newCredentials) {
        userService.updatePassword(newCredentials);
    }

    @Override
    public void reactivateAccount(String email) {
        userService.reactivateAccount(email);
    }

    //DELETE
    @Override
    public void deleteUserById(long id) {
        userService.deleteUserById(id);
    }

    @Override
    public void updateEmail(EmailChange newCredentials) {
        userService.updateEmail(newCredentials);
    }

}

