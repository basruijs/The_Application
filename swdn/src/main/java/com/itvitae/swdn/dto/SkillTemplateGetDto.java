package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A template for creating new skills.")
public class SkillTemplateGetDto {
    @Schema(
            description = "Unique identifier of the template.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "Name of the skill.",
            example = "Woodcutting",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Whether the skill is a hard skill or a soft skill. (true=hard)",
            example = "true",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean hardSkill;
}
