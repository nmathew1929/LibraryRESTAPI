package com.example.navinmathew.LibraryRESTAPI.repositories;

import com.example.navinmathew.LibraryRESTAPI.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testByName() {
       //User user = userRepository.findUserByFirstname("Navin");
       Optional<User> user1 =  userRepository.findById(11L);
       //assertEquals(user,  user1);
    }
}