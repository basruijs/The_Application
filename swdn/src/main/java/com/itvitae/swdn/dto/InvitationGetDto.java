package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InvitationGetDto {
    private Long id;
    private PersonGetDto feedbackGiver;
    private PersonGetDto feedbackAsker;
    private LocalDate sendDate;
}
