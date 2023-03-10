package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.FileDto;
import com.itvitae.swdn.model.DBFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    FileDto toDto(DBFile file);
}
