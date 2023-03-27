package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.dto.ChangeRequestGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "changerequest", description = "change request api")
@RequestMapping("/api/changerequest")
public interface ChangeRequestApi {

    //CREATE
    @Operation(
            summary = "Creates a new change request",
            description = "Creates a new change request for the specified person",
            tags = {"changerequest"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new/{personid}")
    void newChangeRequest(@RequestBody ChangeRequestDto changeRequestDto, @PathVariable(value = "personid") long personid);

    //READ
    @Operation(
            summary = "Returns a change request",
            description = "Returns the open change request for the specified person",
            tags = {"changerequest"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ChangeRequestGetDto.class)))
    @GetMapping(value = "/byperson/{id}", produces = {"application/json"})
    ChangeRequestGetDto getRequestByPerson(@PathVariable(value = "id") long id);


    //DELETE
    @Operation(
            summary = "Deletes a change request",
            description = "Deletes the change request with the specified id",
            tags = {"changerequest"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/delete/{id}")
    void deleteChangeRequest(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Denies a change request",
            description = "Denies the change request with the specified id, for the reason specified in the body.",
            tags = {"changerequest"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/deny/{id}")
    void denyChangeRequest(@PathVariable(value = "id") long id, @RequestBody String message);
}
