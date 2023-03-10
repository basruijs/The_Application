package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.*;
import com.itvitae.swdn.mapper.EvaluationMapper;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.model.Evaluation;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.repository.EvaluationRepository;
import com.itvitae.swdn.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class EvaluationService {
    @Autowired
    EvaluationRepository evaluationRepository;
    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;


    public void newEvaluation(EvaluationPostDto evaluationDto, long evaluatorid, long traineeid) {

        EvaluationPostDto newEvaluation = evaluationDto;

        //set evaluators
        PersonGetDto evaluator = personMapper.toDto(personRepository.findById(evaluatorid).get());
//        personMapper.toEntity(evaluator).getEvaluatorEvaluations().add(evaluationMapper.toEntity(newEvaluation));
        newEvaluation.setEvaluator(evaluator);

        //set trainee
        PersonGetDto trainee = personMapper.toDto(personRepository.findById(traineeid).get());
//        personMapper.toEntity(evaluator).getTraineeEvaluations().add(evaluationMapper.toEntity(newEvaluation));
        newEvaluation.setTrainee(trainee);


        evaluationRepository.save(evaluationMapper.toEntity(newEvaluation));

    }

    public EvaluationGetDto getEvaluationById(long id) {
        Optional<Evaluation> foundEvaluation = evaluationRepository.findById(id);
        if (!foundEvaluation.isPresent()) {
            throw new IllegalArgumentException("No such meeting exists");
        }
        return evaluationMapper.toDto(foundEvaluation.get());
    }

    public Iterable<EvaluationGetDto> getAllEvaluations() {
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }

    public Iterable<EvaluationGetDto> getSkillByTrainee(long traineeid) {
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> Objects.equals(evaluation.getTrainee().getId(), traineeid))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }

    public Iterable<EvaluationGetDto> getSkillByEvaluator(long evaluatorid) {
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> Objects.equals(evaluation.getEvaluator().getId(), evaluatorid))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }
}
