package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.EvaluationDto;
import com.itvitae.swdn.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService;


    @PostMapping("/new/{coachid}/{traineeid}")
    public void newEvaluation(@RequestBody EvaluationDto evaluationDto, @PathVariable(value = "coachid") long coachid, @PathVariable(value = "traineeid") long traineeid) {
        evaluationService.newEvaluation(evaluationDto, coachid, traineeid);
    }

    //READ
    @GetMapping("/get/{id}")
    public EvaluationDto getEvaluationById(@PathVariable(value = "id") long id) {
        return evaluationService.getEvaluationById(id);
    }


    @GetMapping("/trainee/{traineeid}/all")
    public Iterable<EvaluationDto> getSkillByTrainee(@PathVariable(value = "traineeid") long traineeid) {
        return evaluationService.getSkillByTrainee(traineeid);
    }

    @GetMapping("/evaluator/{evaluatorid}/all")
    public Iterable<EvaluationDto> getSkillByEvaluator(@PathVariable(value = "evaluatorid") long evaluatorid) {
        return evaluationService.getSkillByEvaluator(evaluatorid);
    }
}
