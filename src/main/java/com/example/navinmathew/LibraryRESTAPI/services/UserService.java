package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<Object> findUserById(Long id);
    List<User> findAllUsers();
    User saveUser(User user);
    void deleteUser(Long id);

}
