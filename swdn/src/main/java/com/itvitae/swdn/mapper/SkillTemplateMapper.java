package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillTemplateGetDto;
import com.itvitae.swdn.model.SkillTemplate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillTemplateMapper {
    SkillTemplate toEntity(SkillPostDto skillDto);

    SkillTemplateGetDto toDto(SkillTemplate skillTemplate);

    SkillPostDto toSkillDto(SkillTemplate skillTemplate);
}
