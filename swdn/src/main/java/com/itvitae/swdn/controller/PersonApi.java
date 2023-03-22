package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.NawDto;
import com.itvitae.swdn.dto.PersonGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "person", description = "person api")
@RequestMapping("/api/person")
public interface PersonApi {
    //READ
    @Operation(
            summary = "Returns a person",
            description = "Returns the details of a specified person",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/{id}", produces = {"application/json"})
    PersonGetDto getPersonById(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Returns all people",
            description = "Returns the details of all people in the database. Only for HR employees.",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/all", produces = "application/json")
    Iterable<PersonGetDto> getAllPeople();

    @Operation(
            summary = "Returns trainees of coach",
            description = "Returns the trainees of the specified coach",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/gettrainees/{id}", produces = "application/json")
    Iterable<PersonGetDto> getTrainees(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Returns subordinates of manager",
            description = "Returns the subordinates of the specified manager",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @GetMapping(value = "/getsubordinates/{id}", produces = "application/json")
    Iterable<PersonGetDto> getSubordinates(@PathVariable(value = "id") long id);

    //UPDATE
    @Operation(
            summary = "Updates personal information",
            description = "Updates the personal information of the specified person",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/update/{id}")
    void updatePersonById(@PathVariable(value = "id") long id, @RequestBody NawDto nawDto);

    @Operation(
            summary = "Sets manager and coach",
            description = "Sets the manager and coach of the specified person",
            tags = {"person"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/setpeople/{id}/coach/{coachid}/manager/{managerid}")
    void setPeople(@PathVariable(value = "id") long id, @PathVariable(value = "coachid") long coachid, @PathVariable(value = "managerid") long managerid);
}
