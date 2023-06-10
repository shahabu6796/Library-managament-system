package com.library.com.Library.managament.system.controller;

import com.library.com.Library.managament.system.entity.User;
import com.library.com.Library.managament.system.service.UserService;
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
