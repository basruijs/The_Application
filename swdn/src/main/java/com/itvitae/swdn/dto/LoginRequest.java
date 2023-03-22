package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Credentials for logging in")
public class LoginRequest {
    @Schema(description = "Email address used to log in.",
            example = "john.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "Password used to log in.",
            example = "P@ssword123",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
