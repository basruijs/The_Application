package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.*;
import com.itvitae.swdn.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/invitation")
public class InvitationController {
    @Autowired
    InvitationService invitationService;

    @PostMapping("/new/{requesterid}")
    public void newInvitation(@RequestBody InvitationDto invitationDto, @PathVariable(value = "requesterid") Long requesterid) {
        invitationService.newInvitation(invitationDto, requesterid);
    }

    @PutMapping("/update/{id}")
    public void giveFeedback(@PathVariable(value = "id") long id, @RequestBody InvitationPutDto invitation) {
        invitationService.giveFeedback(id, invitation);
    }

    @GetMapping("/requesters/{giverid}")
    public Iterable<InvitationGetDto> getRequestersByGiver(@PathVariable(value = "giverid") Long giverid) {
        return invitationService.getRequestersByGiver(giverid);
    }
    @GetMapping("/givers/{requesterid}")
    public Iterable<InvitationGetDto> getGiversByRequester(@PathVariable(value = "requesterid") Long requesterid) {
        return invitationService.getGiversByRequester(requesterid);
    }

}
