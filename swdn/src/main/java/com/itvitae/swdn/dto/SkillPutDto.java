package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class SkillPutDto {
    private String name;
    private Boolean completed;
    private Boolean hardSkill;
    private String report;
    private File certificate;
}
