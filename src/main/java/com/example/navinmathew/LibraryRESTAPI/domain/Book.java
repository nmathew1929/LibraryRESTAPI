package com.example.navinmathew.LibraryRESTAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("books")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("books")
    private Category category;

}
