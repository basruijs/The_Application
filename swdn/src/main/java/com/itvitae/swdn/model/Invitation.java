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
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "feedback_asker_id")
    private Person feedbackAsker;
    @ManyToOne
    @JoinColumn(name = "feedback_giver_id")
    private Person feedbackGiver;
    private LocalDate sendDate;
    private String feedback;

    private boolean deleted = false;

}
