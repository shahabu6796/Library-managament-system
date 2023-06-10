package com.library.com.Library.managament.system.service;

import com.library.com.Library.managament.system.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    ResponseEntity<String> crateUser(User user);

    ResponseEntity<String> loginUser(String userEmail, String password);
    boolean isUserAlreadyExists(String userEmail);
}
