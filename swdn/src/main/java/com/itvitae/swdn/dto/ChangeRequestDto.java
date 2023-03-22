package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A request by a user to change personal details.")
public class ChangeRequestDto {
    @Schema(description = "New name of the user, if applicable.",
            example = "Jane Smith")
    private String name;
    @Schema(description = "New address of the user, if applicable.",
            example = "42 Oak Lane")
    private String address;
    @Schema(description = "New city of the user, if applicable.",
            example = "New York City")
    private String city;
    @Schema(description = "The person who requested the change.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private PersonGetDto requester;
}
