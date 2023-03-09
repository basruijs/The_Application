package com.itvitae.swdn.controller;


import com.itvitae.swdn.dto.SkillGetDto;
import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public Iterable<SkillGetDto> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{traineeid}/all")
    public Iterable<SkillGetDto> getSkillByPerson(@PathVariable(value = "traineeid") long traineeid) {
        return skillService.getSkillByPerson(traineeid);
    }
}
