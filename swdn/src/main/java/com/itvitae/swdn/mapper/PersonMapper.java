package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonGetDto toDto(Person person);
}
