package com.itvitae.swdn.controller;

import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillTemplateGetDto;
import com.itvitae.swdn.service.SkillTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SkillTemplateController implements SkillTemplateApi {
    @Autowired
    SkillTemplateService skillTemplateService;

    //CREATE
    @Override
    public void newTemplate(SkillPostDto skillDto) {
        skillTemplateService.newTemplate(skillDto);
    }

    //READ
    @Override
    public SkillTemplateGetDto getTemplateById(long id) {
        return skillTemplateService.getTemplateById(id);
    }

    @Override
    public Iterable<SkillTemplateGetDto> getAllTemplates() {
        return skillTemplateService.getAllTemplates();
    }

    //UPDATE
    @Override
    public void updateTemplate(long id, SkillPostDto skill) {
        skillTemplateService.updateTemplate(id, skill);
    }

    @Override
    public void assignSkillFromTemplate(long templateId, long traineeId) {
        skillTemplateService.assignSkillFromTemplate(templateId, traineeId);
    }

    //DELETE
    @Override
    public void deleteTemplateById(long id) {
        skillTemplateService.deleteTemplateById(id);
    }
}
