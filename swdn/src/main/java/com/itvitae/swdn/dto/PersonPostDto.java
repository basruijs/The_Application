package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A new person being created.")
public class PersonPostDto {
    @Schema(
            description = "Name of the person.",
            example = "John Smith",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Address of the person.",
            example = "10 Main Street",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(description = "City where the person lives.",
            example = "London",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;
}
