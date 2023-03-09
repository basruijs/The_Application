package com.itvitae.swdn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Person trainee;
    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private Person evaluator;
    private LocalDate date;


}
