package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.dto.ChangeRequestGetDto;
import com.itvitae.swdn.service.ChangeRequestService;
import com.itvitae.swdn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChangeRequestController implements ChangeRequestApi {
    @Autowired
    ChangeRequestService changeRequestService;

    @Autowired
    EmailService emailService;

    //CREATE
    @Override
    public void newChangeRequest(ChangeRequestDto changeRequestDto, long personid) {
        changeRequestService.addChangeRequest(changeRequestDto, personid);
    }


    //READ
    @Override
    public ChangeRequestGetDto getRequestByPerson(long id) {
        return changeRequestService.getRequestByPerson(id);
    }


    //DELETE
    @Override
    public void deleteChangeRequest(long id) {
        changeRequestService.deleteChangeRequest(id);
    }

    @Override
    public void denyChangeRequest(long id, String message) {
        changeRequestService.denyChangeRequest(id, message);
    }
}
