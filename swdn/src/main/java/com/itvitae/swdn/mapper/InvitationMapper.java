package com.itvitae.swdn.mapper;

import com.itvitae.swdn.dto.InvitationDto;
import com.itvitae.swdn.dto.InvitationGetDto;
import com.itvitae.swdn.model.Invitation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvitationMapper {
    Invitation toEntity(InvitationDto invitation);

    InvitationGetDto toDto(Invitation skill);
}
