package com.itvitae.swdn.controller;


import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.service.PersonService;
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
    public void newUser(@RequestBody SkillDto skillDto, @PathVariable(value = "personid") long personid) {
        skillService.newUser(skillDto, personid);
    }
    //READ
    @GetMapping("/{id}")
    public SkillDto getSkillById(@PathVariable(value = "id") long id) {
        return skillService.getSkillById(id);
    }

    @GetMapping("/all")
    public Iterable<SkillDto> getAllPeople() {
        return skillService.getAllSkills();
    }
}
