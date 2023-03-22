package com.itvitae.swdn.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "File stored in the database.")
public class FileDto {
    @Schema(description = "Name of the file.",
            example = "certificate.docx",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String fileName;
    @Schema(description = "File format of the file.",
            example = "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String fileType;
    @Schema(description = "Representation of the content of the file.",
            example = "UEsDBBQABgAIAA8dZVb8x6eDyAEAAPQL…",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private byte[] data;
}
