package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.User;

import java.util.List;

public interface UserService {

    User findCustomerById(Long id);
    List<User> findAllUsers();

    User saveUser(User user);
}
