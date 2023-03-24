package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillTemplateGetDto;
import com.itvitae.swdn.mapper.SkillTemplateMapper;
import com.itvitae.swdn.model.SkillTemplate;
import com.itvitae.swdn.repository.SkillTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SkillTemplateService {
    @Autowired
    SkillTemplateRepository skillTemplateRepository;
    @Autowired
    SkillTemplateMapper skillTemplateMapper;
    @Autowired
    SkillService skillService;

    public void newTemplate(SkillPostDto skillDto) {
        skillTemplateRepository.save(skillTemplateMapper.toEntity(skillDto));
    }

    public SkillTemplateGetDto getTemplateById(long id) {
        Optional<SkillTemplate> foundTemplate = skillTemplateRepository.findById(id);
        if (!foundTemplate.isPresent()) {
            throw new IllegalArgumentException("Template does not exist");
        }
        return skillTemplateMapper.toDto(foundTemplate.get());
    }

    public Iterable<SkillTemplateGetDto> getAllTemplates() {
        return StreamSupport
                .stream(skillTemplateRepository.findAll().spliterator(), false)
                .map(template -> skillTemplateMapper.toDto(template))
                .collect(Collectors.toList());
    }

    public void updateTemplate(long id, SkillPostDto skill) {
        Optional<SkillTemplate> foundTemplate = skillTemplateRepository.findById(id);
        if (!foundTemplate.isPresent()) {
            throw new IllegalArgumentException("Template does not exist");
        }
        SkillTemplate template = foundTemplate.get();
        if (skill.getName() != null) {
            template.setName(skill.getName());
        }
        if (skill.getHardSkill() != null) {
            template.setHardSkill(skill.getHardSkill());
        }
        skillTemplateRepository.save(template);
    }

    public void deleteTemplateById(long id) {
        if (!skillTemplateRepository.existsById(id)) {
            throw new IllegalArgumentException("Template does not exist");
        }
        skillTemplateRepository.deleteById(id);
    }

    public void assignSkillFromTemplate(long templateId, long traineeId) {
        Optional<SkillTemplate> foundTemplate = skillTemplateRepository.findById(templateId);
        if (!foundTemplate.isPresent()) {
            throw new IllegalArgumentException("Template does not exist");
        }
        skillService.newSkill(skillTemplateMapper.toSkillDto(foundTemplate.get()), traineeId);
    }
}
