package com.itvitae.swdn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String roles;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public User(String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
