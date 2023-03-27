package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "A skill that a user is trying to train or has trained in the past.")
public class SkillGetDto {
    @Schema(
            description = "Unique identifier of the skill.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "Name of the skill.",
            example = "Woodcutting",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Whether the user has completed training of the skill.",
            example = "false",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean completed;
    @Schema(description = "Whether the skill is a hard skill or a soft skill. (true=hard)",
            example = "true",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean hardSkill;

    @Schema(description = "Description of the skill.",
            example = "Cutting down trees using axes and chainsaws. Includes getting the National Lumber Association Woodcutting 1 certification.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(description = "Report on progress/completion of the skill.",
            example = "Can chop down trees with assistance, using an axe. Can't use a chainsaw or chop trees without assistance yet.")
    private String report;
    @Schema(description = "Goals for learning the skill.",
            example = "- Chop down trees without assistance\n- Learn how to use a chainsaw")
    private String learningGoals;
    @Schema(description = "Certificate awarded for the skill, if applicable.")
    private FileDto certificate;
}
