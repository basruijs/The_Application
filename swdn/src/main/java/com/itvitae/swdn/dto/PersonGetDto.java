package com.itvitae.swdn.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itvitae.swdn.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonGetDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private UserGetDto user;
}
