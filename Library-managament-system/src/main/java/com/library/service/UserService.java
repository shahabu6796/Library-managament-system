package com.library.service;

import com.library.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> crateUser(User user);

    ResponseEntity<String> loginUser(String userEmail, String password);
    boolean isUserAlreadyExists(String userEmail);
}
