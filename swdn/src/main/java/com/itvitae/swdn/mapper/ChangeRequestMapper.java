package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.model.ChangeRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangeRequestMapper {
    ChangeRequest toEntity(ChangeRequestDto changeRequestDto);
}
