package com.example.navinmathew.LibraryRESTAPI.controllers;


import com.example.navinmathew.LibraryRESTAPI.domain.User;
import com.example.navinmathew.LibraryRESTAPI.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUser() {
       return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveCustomer(@RequestBody User user) {
        return userService.saveUser(user);
    }


}
