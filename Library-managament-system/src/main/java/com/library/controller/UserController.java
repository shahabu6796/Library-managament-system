package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> createAccount(@RequestBody User user) {
        return userService.crateUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String userEmail, @RequestParam String password) {
        return userService.loginUser(userEmail, password);
    }
}
