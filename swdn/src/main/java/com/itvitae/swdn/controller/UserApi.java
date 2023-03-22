package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.LoginRequest;
import com.itvitae.swdn.dto.PasswordChange;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.UserPostDto;
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
            description = "Updates the password of a user",
            tags = {"user"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/changepassword")
    void updatePassword(@RequestBody PasswordChange newCredentials);
}
