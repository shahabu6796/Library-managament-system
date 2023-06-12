package com.library.service;

import java.util.Optional;

import com.library.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> crateUser(User user);

    ResponseEntity<String> loginUser(String userEmail, String password);
    Optional<User> isUserAlreadyExists(String userEmail);
}
