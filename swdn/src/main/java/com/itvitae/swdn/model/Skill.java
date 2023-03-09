package com.itvitae.swdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    private Boolean completed;
    private Boolean hardSkill;
    @Column(length = 600)
    private String report;
    private File certificate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Person trainee;
}
