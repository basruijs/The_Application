package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonGetDto {
    private Long id;
    private String name;
    private RoleDto role;
    private String address;
    private String city;
    private UserGetDto user;
    private PersonGetDto coach;
    private PersonGetDto manager;
}
