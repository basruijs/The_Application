package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "An invitation to give 360 feedback to a colleague.")
public class InvitationDto {
    @Schema(description = "Email address of the person invited to give feedback",
            example = "jane.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "The person requesting the feedback.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto requester;
    @Schema(description = "The date on which the invitation was sent.",
            example = "2023-03-22",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate sendDate;
}
