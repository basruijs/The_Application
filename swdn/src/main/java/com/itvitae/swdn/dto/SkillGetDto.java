package com.itvitae.swdn.dto;

import com.itvitae.swdn.model.Person;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class SkillGetDto {
    private String name;
    private Boolean completed;
    private Boolean hardSkill;
    private String report;
}
