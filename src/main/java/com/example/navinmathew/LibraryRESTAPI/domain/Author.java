package com.example.navinmathew.LibraryRESTAPI.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String firstname;
    @Column(unique = true)
    private String lastname;


    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> books;


}
