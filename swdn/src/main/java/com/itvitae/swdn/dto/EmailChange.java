package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A request to change the email address of a user")
public class EmailChange {
    @Schema(description = "Old email address of the account requesting the change.",
            example = "john.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String oldEmail;
    @Schema(description = "New email address that will replace the old one.",
            example = "jane.smith@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String newEmail;
    @Schema(description = "Password of the user, for verification purposes.",
            example = "P@ssword123",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

}

