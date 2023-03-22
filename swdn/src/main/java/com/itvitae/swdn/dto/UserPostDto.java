package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A new user being created.")
public class UserPostDto {
    @Schema(description = "Email address of the user.",
            example = "john.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "Password of the user.",
            example = "P@ssword123",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "Auth roles of the user.",
            example = "ROLE_TRAINEE",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String roles;
    @Schema(description = "Personal details of the user.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonPostDto person;
}
