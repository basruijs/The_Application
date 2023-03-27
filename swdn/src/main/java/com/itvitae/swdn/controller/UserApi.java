package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user", description = "user api")
@RequestMapping("/api/user")
public interface UserApi {
    //CREATE
    @Operation(
            summary = "Creates a new user entity",
            description = "Creates a new user with the specified role",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new/{roleid}")
    void newUser(@RequestBody UserPostDto userPostDto, @PathVariable(value = "roleid") long roleid);

    @Operation(
            summary = "Logs in the user using the specified credentials",
            description = "Returns the personal information of the user who logs in",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = PersonGetDto.class)))
    @PostMapping(value = "/login", produces = {"application/json"})
    PersonGetDto authenticateUser(@RequestBody LoginRequest loginRequest);

    //UPDATE
    @Operation(
            summary = "Updates the password of a user",
            description = "Replaces the password of a user with a new one",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/changepassword")
    void updatePassword(@RequestBody PasswordChange newCredentials);

    @Operation(
            summary = "Updates the email of a user",
            description = "Replaces the email address of a user with a new one",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/changeemail")
    void updateEmail(@RequestBody EmailChange newCredentials);

    @Operation(
            summary = "Restores an archived account",
            description = "Restores the user and all related archived information",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/restore")
    void reactivateAccount(@RequestBody String email);

    //DELETE
    @Operation(
            summary = "Deletes a user and the related person",
            description = "Deletes a user and the related person",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/delete/{id}")
    void deleteUserById(@PathVariable(value = "id") long id);
}
