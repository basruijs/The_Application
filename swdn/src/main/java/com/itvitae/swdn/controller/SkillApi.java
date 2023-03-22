package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.SkillGetDto;
import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillPutDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "skill", description = "skill api")
@RequestMapping("/api/skill")
public interface SkillApi {
    @Operation(
            summary = "Creates a new skill",
            description = "Creates a new skill for the specified person",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new/{personid}")
    void newSkill(@RequestBody SkillPostDto skillDto, @PathVariable(value = "personid") long personid);

    //READ
    @Operation(
            summary = "Returns a skill",
            description = "Returns the specified skill",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = SkillController.class)))
    @GetMapping(value = "/{id}", produces = {"application/json"})
    SkillGetDto getSkillById(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Returns all skills",
            description = "Returns all skills of the specified trainee",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = SkillController.class)))
    @GetMapping(value = "/{traineeid}/all", produces = "application/json")
    Iterable<SkillGetDto> getSkillByPerson(@PathVariable(value = "traineeid") long traineeid);

    //UPDATE
    @Operation(
            summary = "Updates a skill",
            description = "Updates the details of the specified skill",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/update/{id}")
    void updateSkill(@PathVariable(value = "id") long id, @RequestBody SkillPutDto skill);

    @Operation(
            summary = "Adds a certificate",
            description = "Adds a certificate to the specified skill",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/add/certificate/{id}")
    void addCertificate(@PathVariable(value = "id") long id, @RequestParam("file") MultipartFile file) throws IOException;

    @Operation(
            summary = "Download link for certificate",
            description = "Allows downloading the certificate of the specified skill",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/certificate/{id}")
    ResponseEntity<Resource> downloadCertificate(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Deletes a skill",
            description = "Deletes the specified skill",
            tags = {"skill"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/delete/{id}")
    void deleteSkillById(@PathVariable(value = "id") long id);
}
