package com.itvitae.swdn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Person trainee;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private Person evaluator;
    private LocalDate date;
    private LocalTime time;
    private LocalTime duration;


}
