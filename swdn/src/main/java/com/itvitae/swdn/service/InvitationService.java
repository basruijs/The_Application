package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.InvitationDto;
import com.itvitae.swdn.mapper.InvitationMapper;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.model.Invitation;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Skill;
import com.itvitae.swdn.repository.InvitationRepository;
import com.itvitae.swdn.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvitationService {

    @Autowired
    InvitationMapper invitationMapper;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;
    @Autowired
    InvitationRepository invitationRepository;

    public void newInvitation(InvitationDto invitationDto, long requesterid) {
        Invitation invitation = invitationMapper.toEntity(invitationDto);
        Person requester = personRepository.findById(requesterid).get();

        Person giver = StreamSupport
                .stream(personRepository.findAll().spliterator(), false)
                .filter(person -> Objects.equals(person.getUser().getEmail(), invitationDto.getEmail()))
                .filter(person -> Objects.equals(person.getRole().getName(), "TRAINEE"))

                .findFirst()
                .orElse(null);


        if(giver != null) {
            giver.getReceivedInvitations().add(invitation);
            requester.getSentInvitations().add(invitation);
            invitation.setFeedbackAsker(requester);
            invitationRepository.save(invitation);
        }
    }
}
