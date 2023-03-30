package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.InvitationDto;
import com.itvitae.swdn.dto.InvitationGetDto;
import com.itvitae.swdn.dto.InvitationPutDto;
import com.itvitae.swdn.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InvitationController implements InvitationApi {
    @Autowired
    InvitationService invitationService;

    //CREATE
    @Override
    public void newInvitation(InvitationDto invitationDto, Long requesterid) {
        invitationService.newInvitation(invitationDto, requesterid);
    }

    //READ
    @Override
    public Iterable<InvitationGetDto> getRequestersByGiver(Long giverid) {
        return invitationService.getRequestersByGiver(giverid);
    }

    @Override
    public Iterable<InvitationGetDto> getGiversByRequester(Long requesterid) {
        return invitationService.getGiversByRequester(requesterid);
    }

    //UPDATE
    @Override
    public void giveFeedback(long id, InvitationPutDto invitation) {
        invitationService.giveFeedback(id, invitation);
    }

}
