package com.example.navinmathew.LibraryRESTAPI.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryname;

//    @OneToOne
//    private Book book;

}
