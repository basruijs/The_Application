package com.itvitae.swdn.dto;

import com.itvitae.swdn.model.DBFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillGetDto {
    private Long id;
    private String name;
    private Boolean completed;
    private Boolean hardSkill;
    private String report;
    private DBFile certificate;
}
