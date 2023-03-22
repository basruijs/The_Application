package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A request to change the password of a user")
public class PasswordChange {
    @Schema(description = "Email address of the account requesting the change.",
            example = "john.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "Old password that will be replaced.",
            example = "P@ssword123",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String oldPassword;
    @Schema(description = "New password that will replace the old one.",
            example = "P@$$word321",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String newPassword;
}
