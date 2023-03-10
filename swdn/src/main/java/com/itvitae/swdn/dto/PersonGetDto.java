package com.itvitae.swdn.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonGetDto {
    private Long id;
    private String name;
//    private List<EvaluationGetDto> traineeEvaluations = new ArrayList<>();
//    private List<EvaluationGetDto> evaluatorEvaluations = new ArrayList<>();
}
