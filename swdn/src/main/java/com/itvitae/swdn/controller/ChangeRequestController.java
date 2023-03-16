package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.dto.ChangeRequestGetDto;
import com.itvitae.swdn.service.ChangeRequestService;
import com.itvitae.swdn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/changerequest")
public class ChangeRequestController {
    @Autowired
    ChangeRequestService changeRequestService;

    @Autowired
    EmailService emailService;

    @PostMapping("/new/{personid}")
    public void newChangeRequest(@RequestBody ChangeRequestDto changeRequestDto, @PathVariable(value = "personid") long personid) {
        changeRequestService.addChangeRequest(changeRequestDto, personid);
    }

    @GetMapping("/testmail")
    public void sendTestEmail() {
        System.out.println("Sending test email");
        emailService.sendEmail("menno.muller@itvitaelearning.nl", "Test Email", "This is the body text of the test email.");
    }

    @GetMapping("/byperson/{id}")
    public ChangeRequestGetDto getRequestByPerson(@PathVariable(value = "id") long id) {
        return changeRequestService.getRequestByPerson(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChangeRequest(@PathVariable(value = "id") long id) {
        changeRequestService.deleteChangeRequest(id);
    }
}
