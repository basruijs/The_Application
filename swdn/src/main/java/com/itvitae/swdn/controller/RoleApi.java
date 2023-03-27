package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.PersonGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "role", description = "role api")
@RequestMapping("/api/role")
public interface RoleApi {

    //READ
    @Operation(
            summary = "Returns all trainees",
            description = "Returns all people with the trainee role",
            tags = {"role"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/trainee/all", produces = "application/json")
    Iterable<PersonGetDto> getAllTrainees();

    @Operation(
            summary = "Returns all coaches",
            description = "Returns all people with the coach role",
            tags = {"role"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/coach/all", produces = "application/json")
    Iterable<PersonGetDto> getAllCoaches();

    @Operation(
            summary = "Returns all managers",
            description = "Returns all people with the manager role",
            tags = {"role"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/manager/all", produces = "application/json")
    Iterable<PersonGetDto> getAllManagers();

}
