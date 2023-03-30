package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.EvaluationDto;
import com.itvitae.swdn.model.Evaluation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {
    EvaluationDto toDto(Evaluation evaluation);

    Evaluation toEntity(EvaluationDto evaluationDto);
}
