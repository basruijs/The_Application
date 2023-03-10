package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillPutDto {
    private String name;
    private Boolean completed;
    private Boolean hardSkill;
    private String report;
}
