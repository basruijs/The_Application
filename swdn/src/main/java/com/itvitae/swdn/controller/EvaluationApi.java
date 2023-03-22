package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.EvaluationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "evaluation", description = "evaluation meeting api")
@RequestMapping("/api/evaluation")
public interface EvaluationApi {
    @Operation(
            summary = "Plans a new evaluation meeting",
            description = "Creates a new evaluation meeting between the specified people",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/new/{coachid}/{traineeid}")
    void newEvaluation(@RequestBody EvaluationDto evaluationDto, @PathVariable(value = "coachid") long coachid, @PathVariable(value = "traineeid") long traineeid);

    //READ
    @Operation(
            summary = "Returns an evaluation meeting",
            description = "Returns the specified evaluation meeting",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = EvaluationDto.class)))
    @GetMapping(value = "/get/{id}", produces = {"application/json"})
    EvaluationDto getEvaluationById(@PathVariable(value = "id") long id);

    @Operation(
            summary = "Returns evaluation meetings of a trainee",
            description = "Returns all evaluation meetings of the specified trainee",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = EvaluationDto.class)))
    @GetMapping(value = "/trainee/{traineeid}/all", produces = "application/json")
    Iterable<EvaluationDto> getAllEvaluationsByTrainee(@PathVariable(value = "traineeid") long traineeid);

    @Operation(
            summary = "Returns evaluation meetings of an evaluator",
            description = "Returns all evaluation meetings of the specified evaluator",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = EvaluationDto.class)))
    @GetMapping(value = "/evaluator/{evaluatorid}/all", produces = "application/json")
    Iterable<EvaluationDto> getAllEvaluationsByEvaluator(@PathVariable(value = "evaluatorid") long evaluatorid);

    @Operation(
            summary = "Returns future evaluation meetings of a trainee",
            description = "Returns all future evaluation meetings of the specified trainee",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = EvaluationDto.class)))
    @GetMapping(value = "/trainee/{traineeid}/future", produces = "application/json")
    Iterable<EvaluationDto> getFutureEvaluationsByTrainee(@PathVariable(value = "traineeid") long traineeid);

    @Operation(
            summary = "Returns future evaluation meetings of an evaluator",
            description = "Returns all future evaluation meetings of the specified evaluator",
            tags = {"evaluation"}
    )
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = EvaluationDto.class)))
    @GetMapping(value = "/evaluator/{evaluatorid}/future", produces = "application/json")
    Iterable<EvaluationDto> getFutureEvaluationsByEvaluator(@PathVariable(value = "evaluatorid") long evaluatorid);
}
