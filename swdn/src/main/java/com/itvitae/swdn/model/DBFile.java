package com.itvitae.swdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DBFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String fileName;
    private String fileType;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;

    @OneToOne(mappedBy = "certificate")
    @JsonIgnore
    private Skill skill;

    private boolean deleted = false;

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
