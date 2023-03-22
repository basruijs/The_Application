package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "An invitation to give 360 feedback to a colleague.")
public class InvitationGetDto {
    @Schema(
            description = "Unique identifier of the invitation to give feedback.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "The person giving the feedback.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto feedbackGiver;
    @Schema(description = "The person requesting the feedback.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto feedbackAsker;
    @Schema(description = "The date on which the invitation was sent.",
            example = "2023-03-22",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate sendDate;
    @Schema(description = "The feedback given to the colleague.",
            example = "I think you're a very hard worker, but you could improve the way you interact with customers.")
    private String feedback;
}
