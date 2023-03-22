package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    @Schema(description = "Name of the role",
            example = "TRAINEE",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}
