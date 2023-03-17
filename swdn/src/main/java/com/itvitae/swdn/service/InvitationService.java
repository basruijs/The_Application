package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.InvitationDto;
import com.itvitae.swdn.dto.InvitationGetDto;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.mapper.InvitationMapper;
import com.itvitae.swdn.model.Invitation;
import com.itvitae.swdn.model.Person;
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
    EmailService emailService;

    @Autowired
    InvitationMapper invitationMapper;

    @Autowired
    PersonRepository personRepository;
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
            String emailText = "Hello " + giver.getName() + ", \n\n"
                    + "You have recieved an invitation from " + requester.getName() + " to give them 360 feedback.";

            emailService.sendEmail(giver.getUser().getEmail(), "Feedback Request", emailText);

            giver.getReceivedInvitations().add(invitation);
            requester.getSentInvitations().add(invitation);
            invitation.setFeedbackAsker(requester);
            invitation.setFeedbackGiver(giver);
            invitationRepository.save(invitation);
        } else {
            throw new RuntimeException("email not found");
        }
    }

    public Iterable<InvitationGetDto> getRequestersByGiver(Long giverid) {
        return StreamSupport
                .stream(invitationRepository.findAll().spliterator(), false)
                .filter(invitation -> Objects.equals(invitation.getFeedbackGiver().getId(), giverid))
                .map(invitation -> invitationMapper.toDto(invitation))
                .collect(Collectors.toList());
    }

    public Iterable<InvitationGetDto> getGiversByRequester(Long requesterid) {
        return StreamSupport
                .stream(invitationRepository.findAll().spliterator(), false)
                .filter(invitation -> Objects.equals(invitation.getFeedbackAsker().getId(), requesterid))
                .map(invitation -> invitationMapper.toDto(invitation))
                .collect(Collectors.toList());
    }
}
