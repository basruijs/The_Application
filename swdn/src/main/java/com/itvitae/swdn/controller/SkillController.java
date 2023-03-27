package com.itvitae.swdn.controller;


import com.itvitae.swdn.dto.SkillGetDto;
import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillPutDto;
import com.itvitae.swdn.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class SkillController implements SkillApi {

    @Autowired
    SkillService skillService;

    @Override
    public void newSkill(@RequestBody SkillPostDto skillDto, @PathVariable(value = "personid") long personid) {
        skillService.newSkill(skillDto, personid);
    }

    //READ
    @Override
    public SkillGetDto getSkillById(@PathVariable(value = "id") long id) {
        return skillService.getSkillById(id);
    }


    @Override
    public Iterable<SkillGetDto> getSkillByPerson(@PathVariable(value = "traineeid") long traineeid) {
        return skillService.getSkillByPerson(traineeid);
    }

    @Override
    public ResponseEntity<Resource> downloadCertificate(@PathVariable(value = "id") long id) {
        return skillService.downloadCertificate(id);
    }

    //UPDATE
    @Override
    public void updateSkill(@PathVariable(value = "id") long id, @RequestBody SkillPutDto skill) {
        System.out.println("update skill");
        skillService.updateSkill(id, skill);
    }

    @Override
    public void addCertificate(@PathVariable(value = "id") long id, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("add certificate");
        skillService.addCertificate(id, file);
    }

    //DELETE
    @Override
    public void deleteSkillById(@PathVariable(value = "id") long id) {
        skillService.deleteSkillById(id);
    }

}
