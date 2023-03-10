package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EvaluationDto {
    private Long id;
    private PersonGetDto trainee;
    private PersonGetDto evaluator;
    private LocalDate date;
    private LocalTime time;
    private LocalTime duration;
}
