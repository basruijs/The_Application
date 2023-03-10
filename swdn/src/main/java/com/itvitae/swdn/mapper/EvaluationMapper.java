package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.EvaluationGetDto;
import com.itvitae.swdn.dto.EvaluationPostDto;
import com.itvitae.swdn.model.Evaluation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {
    Evaluation toEntity(EvaluationPostDto evaluationDto);

    EvaluationGetDto toDto(Evaluation evaluation);
}
