package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeRequestDto {
    private String name;
    private String address;
    private String city;
    private PersonPostDto requester;
}
