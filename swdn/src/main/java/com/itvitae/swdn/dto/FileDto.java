package com.itvitae.swdn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDto {
    private String fileName;
    private String fileType;
    private byte[] data;
}
