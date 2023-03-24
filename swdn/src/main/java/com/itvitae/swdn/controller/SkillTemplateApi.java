package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillTemplateGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "template", description = "skill template api")
@RequestMapping("/api/template")
public interface SkillTemplateApi {
    //CREATE
    @Operation(
            summary = "Creates a new skill template",
            description = "Creates a new skill template in the list of skill templates",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new")
    void newTemplate(@RequestBody SkillPostDto skillDto);

    //READ
    @Operation(
            summary = "Returns a skill template",
            description = "Returns the specified skill template",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = SkillTemplateGetDto.class)))
    @GetMapping(value = "/{id}", produces = {"application/json"})
    SkillTemplateGetDto getTemplateById(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Returns all skill templates",
            description = "Returns all skill templates available",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = SkillTemplateGetDto.class)))
    @GetMapping(value = "/all", produces = "application/json")
    Iterable<SkillTemplateGetDto> getAllTemplates();

    //UPDATE
    @Operation(
            summary = "Updates a skill template",
            description = "Updates the details of the specified skill template",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/update/{id}")
    void updateTemplate(@PathVariable(value = "id") long id, @RequestBody SkillPostDto skill);

    @Operation(
            summary = "Assigns a skill from a template",
            description = "Assigns a skill based on a specified template to a specified trainee",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("/assign/{templateId}/to/{traineeId}")
    void assignSkillFromTemplate(@PathVariable(value = "templateId") long templateId, @PathVariable(value = "traineeId") long traineeId);

    //DELETE
    @Operation(
            summary = "Deletes a skill template",
            description = "Deletes the specified skill template",
            tags = {"template"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/delete/{id}")
    void deleteTemplateById(@PathVariable(value = "id") long id);
}
