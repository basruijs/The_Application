package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.RoleDto;
import com.itvitae.swdn.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);
}
