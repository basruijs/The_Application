package com.itvitae.swdn.dto;

import com.itvitae.swdn.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillPostDto {
    private String name;
    private Person trainee;
}
