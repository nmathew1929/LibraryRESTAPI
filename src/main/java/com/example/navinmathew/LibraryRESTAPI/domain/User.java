package com.example.navinmathew.LibraryRESTAPI.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String pwd;
    private String firstname;
    private String lastname;

    @Enumerated(value = EnumType.STRING)
    private Access access;

}
