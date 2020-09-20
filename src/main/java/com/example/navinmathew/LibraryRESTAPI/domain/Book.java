package com.example.navinmathew.LibraryRESTAPI.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;

    private String title;

    @ManyToMany
    @JoinTable(name = "book_author",
                joinColumns = {@JoinColumn(name="book_id")},
                inverseJoinColumns = {@JoinColumn(name="author_id")})
    private List<Author> authors;

    private String category;

    //@OneToOne
    //private Category category;





}
