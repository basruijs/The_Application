package com.itvitae.swdn.controller;

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
}
