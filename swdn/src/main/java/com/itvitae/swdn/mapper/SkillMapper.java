package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.SkillGetDto;
import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillGetDto toDto(Skill skill);

    Skill toEntity(SkillPostDto skillDto);
}
