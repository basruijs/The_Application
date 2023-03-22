package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.InvitationDto;
import com.itvitae.swdn.dto.InvitationGetDto;
import com.itvitae.swdn.dto.InvitationPutDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "feedback", description = "360 feedback invitation api")
@RequestMapping("/api/invitation")
public interface InvitationApi {
    @Operation(
            summary = "Creates a new feedback request",
            description = "Creates a new feedback request from the specified person",
            tags = {"feedback"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new/{requesterid}")
    void newInvitation(@RequestBody InvitationDto invitationDto, @PathVariable(value = "requesterid") Long requesterid);

    @Operation(
            summary = "Adds feedback to a request",
            description = "Adds feedback to the specified request",
            tags = {"feedback"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/update/{id}")
    void giveFeedback(@PathVariable(value = "id") long id, @RequestBody InvitationPutDto invitation);

    @Operation(
            summary = "Returns feedback requests received",
            description = "Returns all feedback requests sent to the specified trainee",
            tags = {"feedback"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = InvitationGetDto.class)))
    @GetMapping(value = "/requesters/{giverid}", produces = "application/json")
    Iterable<InvitationGetDto> getRequestersByGiver(@PathVariable(value = "giverid") Long giverid);

    @Operation(
            summary = "Returns feedback requests sent",
            description = "Returns all feedback requests sent by the specified trainee, including the feedback given to the trainee in response to them",
            tags = {"feedback"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = InvitationGetDto.class)))
    @GetMapping(value = "/givers/{requesterid}", produces = "application/json")
    Iterable<InvitationGetDto> getGiversByRequester(@PathVariable(value = "requesterid") Long requesterid);
}
