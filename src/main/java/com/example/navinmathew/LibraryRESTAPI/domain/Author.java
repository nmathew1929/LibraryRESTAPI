package com.example.navinmathew.LibraryRESTAPI.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public void addBook(Book b) {
        this.books.add(b);
        b.getAuthors().add(this);
    }
}
