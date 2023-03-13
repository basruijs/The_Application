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
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/new/{personid}")
    public void newSkill(@RequestBody SkillPostDto skillDto, @PathVariable(value = "personid") long personid) {
        skillService.newSkill(skillDto, personid);
    }

    //READ
    @GetMapping("/{id}")
    public SkillGetDto getSkillById(@PathVariable(value = "id") long id) {
        return skillService.getSkillById(id);
    }


    @GetMapping("/{traineeid}/all")
    public Iterable<SkillGetDto> getSkillByPerson(@PathVariable(value = "traineeid") long traineeid) {
        return skillService.getSkillByPerson(traineeid);
    }

    //UPDATE
    @PutMapping("/{id}/update")
    public void updateSkill(@PathVariable(value = "id") long id, @RequestBody SkillPutDto skill) {
        skillService.updateSkill(id, skill);
    }

    @PutMapping("/{id}/add/certificate")
    public void addCertificate(@PathVariable(value = "id") long id, @RequestParam("file") MultipartFile file) throws IOException {
        skillService.addCertificate(id, file);
    }

    @GetMapping("/{id}/certificate")
    public ResponseEntity<Resource> downloadCertificate(@PathVariable(value = "id") long id) {
        return skillService.downloadCertificate(id);
    }
}
