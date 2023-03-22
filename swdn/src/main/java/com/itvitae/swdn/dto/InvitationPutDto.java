package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "360 feedback given to a colleague.")
public class InvitationPutDto {
    @Schema(description = "The feedback given to the colleague.",
            example = "I think you're a very hard worker, but you could improve the way you interact with customers.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String feedback;
}
