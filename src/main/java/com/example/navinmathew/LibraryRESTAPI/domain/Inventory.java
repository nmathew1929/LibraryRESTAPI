package com.example.navinmathew.LibraryRESTAPI.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;
}
