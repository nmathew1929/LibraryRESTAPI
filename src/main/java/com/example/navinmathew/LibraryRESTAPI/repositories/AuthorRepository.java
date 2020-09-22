package com.example.navinmathew.LibraryRESTAPI.repositories;

import com.example.navinmathew.LibraryRESTAPI.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByFirstnameAndLastname(String firstName, String lastName);
}
