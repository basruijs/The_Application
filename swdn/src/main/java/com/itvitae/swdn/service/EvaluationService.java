package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.*;
import com.itvitae.swdn.mapper.EvaluationMapper;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.model.Evaluation;
import com.itvitae.swdn.repository.EvaluationRepository;
import com.itvitae.swdn.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    @Autowired
    EmailService emailService;

    public void newEvaluation(EvaluationDto evaluationDto, long evaluatorid, long traineeid) {

        EvaluationDto newEvaluation = evaluationDto;

        PersonGetDto evaluator = personMapper.toDto(personRepository.findById(evaluatorid).get());
        newEvaluation.setEvaluator(evaluator);

        PersonGetDto trainee = personMapper.toDto(personRepository.findById(traineeid).get());
        newEvaluation.setTrainee(trainee);

        String emailText = "Hello " + trainee.getName() + ", \n\n"
                + evaluator.getName() + " scheduled a meeting with you on " +
                newEvaluation.getDate() + " at " + newEvaluation.getTime() + ".\n"
                + "The expected duration is " + newEvaluation.getDuration();

        emailService.sendEmail(trainee.getUser().getEmail(), "Meeting with " + evaluator.getName(), emailText);

        evaluationRepository.save(evaluationMapper.toEntity(newEvaluation));

    }

    public EvaluationDto getEvaluationById(long id) {
        Optional<Evaluation> foundEvaluation = evaluationRepository.findById(id);
        if (!foundEvaluation.isPresent() || foundEvaluation.get().isDeleted()) {
            throw new IllegalArgumentException("No such meeting exists");
        }
        return evaluationMapper.toDto(foundEvaluation.get());
    }

    public Iterable<EvaluationDto> getAllEvaluationsByTrainee(long traineeid) {
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> !evaluation.isDeleted())
                .filter(evaluation -> Objects.equals(evaluation.getTrainee().getId(), traineeid))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }

    public Iterable<EvaluationDto> getAllEvaluationsByEvaluator(long evaluatorid) {
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> !evaluation.isDeleted())
                .filter(evaluation -> Objects.equals(evaluation.getEvaluator().getId(), evaluatorid))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }

    public Iterable<EvaluationDto> getFutureEvaluationsByTrainee(long traineeid) {
        LocalDate date = LocalDate.now();
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> !evaluation.isDeleted())
                .filter(evaluation -> Objects.equals(evaluation.getTrainee().getId(), traineeid))
                .filter(evaluation -> !evaluation.getDate().isBefore(date))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }

    public Iterable<EvaluationDto> getFutureEvaluationsByEvaluator(long evaluatorid) {
        LocalDate date = LocalDate.now();
        return StreamSupport
                .stream(evaluationRepository.findAll().spliterator(), false)
                .filter(evaluation -> !evaluation.isDeleted())
                .filter(evaluation -> Objects.equals(evaluation.getEvaluator().getId(), evaluatorid))
                .filter(evaluation -> !evaluation.getDate().isBefore(date))
                .map(evaluation -> evaluationMapper.toDto(evaluation))
                .collect(Collectors.toList());
    }
}
