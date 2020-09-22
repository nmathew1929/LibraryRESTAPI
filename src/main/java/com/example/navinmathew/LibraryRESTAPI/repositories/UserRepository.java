package com.example.navinmathew.LibraryRESTAPI.repositories;

import com.example.navinmathew.LibraryRESTAPI.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByFirstname(String firstname);
}
