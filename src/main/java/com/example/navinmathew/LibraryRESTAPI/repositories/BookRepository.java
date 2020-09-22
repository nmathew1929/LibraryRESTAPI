package com.example.navinmathew.LibraryRESTAPI.repositories;


import com.example.navinmathew.LibraryRESTAPI.domain.Author;
import com.example.navinmathew.LibraryRESTAPI.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
