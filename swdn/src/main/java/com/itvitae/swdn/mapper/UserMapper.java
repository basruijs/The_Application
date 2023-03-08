package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserPostDto user);
}
