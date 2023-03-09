package com.itvitae.swdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String city;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "person")
    private User user;

    @OneToMany(mappedBy = "feedbackAsker")
    private List<Invitation> sentInvitations = new ArrayList<>();

    @OneToMany(mappedBy = "feedbackGiver")
    private List<Invitation> receivedInvitations = new ArrayList<>();

    @OneToMany(mappedBy = "trainee")
    private List<Evaluation> traineeEvaluations = new ArrayList<>();

    @OneToMany(mappedBy = "evaluator")
    private List<Evaluation> evaluatorEvaluations = new ArrayList<>();

    @OneToOne(mappedBy = "requester")
    private ChangeRequest changeRequest;


    @JsonIgnore
    @OneToMany(mappedBy = "trainee")
    private List<Skill> skills = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Person coach;

    @OneToMany(mappedBy = "coach")
    private List<Person> trainees = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Person manager;

    @OneToMany(mappedBy = "manager")
    private List<Person> subordinates = new ArrayList<>();
}
