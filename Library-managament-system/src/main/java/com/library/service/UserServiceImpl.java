package com.library.service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> crateUser(User user) {
        // call validator call to check that all fields are present or not
        // e.g UserValidator
        // if validation is true then only send object to save inside db
        if (!user.getUserEmail().isEmpty() && !isUserAlreadyExists(user.getUserEmail())) {
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("User Account has been created successfully..");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Alrady exists..");
    }

    public ResponseEntity<String> loginUser(String userEmail, String password) {
        if (userRepository.findByUserEmailAndPassword(userEmail, password) != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfull..");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Email or password");
    }

    @Override
    public boolean isUserAlreadyExists(String userEmail) {
        return userRepository.findByUserEmail(userEmail).isPresent();
    }
}
