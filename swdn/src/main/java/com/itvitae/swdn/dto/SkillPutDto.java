package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A change in the details of a skill.")
public class SkillPutDto {
    @Schema(description = "Name of the skill.",
            example = "Woodcutting")
    private String name;
    @Schema(description = "Whether the user has completed training of the skill.",
            example = "false")
    private Boolean completed;
    @Schema(description = "Whether the skill is a hard skill or a soft skill. (true=hard)",
            example = "true")
    private Boolean hardSkill;
    @Schema(description = "Report on progress/completion of the skill.",
            example = "Can chop down trees with assistance, using an axe. Can't use a chainsaw or chop trees without assistance yet.")
    private String report;
    @Schema(description = "Goals for learning the skill.",
            example = "- Chop down trees without assistance\n- Learn how to use a chainsaw")
    private String learningGoals;
}
