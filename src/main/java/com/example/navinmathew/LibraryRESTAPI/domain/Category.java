package com.example.navinmathew.LibraryRESTAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // if an admin where to add the same, category the admin should be prompted.
    private String categoryname;
    //private String description;


    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Book> books;




}
