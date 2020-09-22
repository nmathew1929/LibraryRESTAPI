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

    private String firstname;
    private String lastname;


    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> books;


}
