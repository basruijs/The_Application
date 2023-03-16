package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
public class InvitationDto {
    private String email;
    private PersonPostDto requester;
    private LocalDate sendDate;
}
