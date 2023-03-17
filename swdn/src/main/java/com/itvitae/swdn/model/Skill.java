package com.itvitae.swdn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String learningGoals;
    @OneToOne
    @JoinColumn(name = "certificate_id")
    private DBFile certificate;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Person trainee;
}
