package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Person object")
public class PersonGetDto {
    @Schema(
            description = "Unique identifier of the person.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(
            description = "Name of the person.",
            example = "John Smith",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Role of the person.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private RoleDto role;
    @Schema(description = "Address of the person.",
            example = "10 Main Street",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(description = "City where the person lives.",
            example = "London",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;
    @Schema(description = "Login credentials of the user.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private UserGetDto user;
    @Schema(description = "Coach of the user.")
    private PersonGetDto coach;
    @Schema(description = "Manager of the user.")
    private PersonGetDto manager;
}
