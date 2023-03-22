package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetDto {
    @Schema(description = "Email address of the user.",
            example = "john.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
}
