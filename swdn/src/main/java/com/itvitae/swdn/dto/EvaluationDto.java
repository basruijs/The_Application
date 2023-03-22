package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Schema(description = "An evaluation meeting between a trainee and their coach or manager.")
public class EvaluationDto {
    @Schema(
            description = "Unique identifier of the evaluation meeting.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "The trainee being evaluated.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto trainee;
    @Schema(description = "The coach or manager evaluating the trainee.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto evaluator;
    @Schema(description = "The date of the meeting.",
            example = "2023-03-22",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;
    @Schema(description = "The starting time of the meeting.",
            example = "14:00",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalTime time;
    @Schema(description = "The duration of the meeting.",
            example = "01:00",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalTime duration;
}
