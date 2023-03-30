package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.EvaluationDto;
import com.itvitae.swdn.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EvaluationController implements EvaluationApi {
    @Autowired
    EvaluationService evaluationService;


    //CREATE
    @Override
    public void newEvaluation(EvaluationDto evaluationDto, long coachid, long traineeid) {
        evaluationService.newEvaluation(evaluationDto, coachid, traineeid);
    }

    //READ
    @Override
    public EvaluationDto getEvaluationById(long id) {
        return evaluationService.getEvaluationById(id);
    }


    @Override
    public Iterable<EvaluationDto> getAllEvaluationsByTrainee(long traineeid) {
        return evaluationService.getAllEvaluationsByTrainee(traineeid);
    }

    @Override
    public Iterable<EvaluationDto> getAllEvaluationsByEvaluator(long evaluatorid) {
        return evaluationService.getAllEvaluationsByEvaluator(evaluatorid);
    }

    @Override
    public Iterable<EvaluationDto> getFutureEvaluationsByTrainee(long traineeid) {
        return evaluationService.getFutureEvaluationsByTrainee(traineeid);
    }

    @Override
    public Iterable<EvaluationDto> getFutureEvaluationsByEvaluator(long evaluatorid) {
        return evaluationService.getFutureEvaluationsByEvaluator(evaluatorid);
    }
}
