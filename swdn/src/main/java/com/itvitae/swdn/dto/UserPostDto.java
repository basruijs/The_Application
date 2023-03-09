package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDto {
    private String email;
    private String password;
    private String roles;
    private PersonPostDto person;
}
