package com.library.service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Autowired
    @Mock
    private UserService userService;
    @Test
    void testCrateUser() {
    }

    @Test
    @DisplayName("login")
    void testLoginUser() {
        String email = "test";
        String password = "test1";
        User user = User.builder().userEmail(email).password(password).build();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        // object is being saved in db which shoul not happen
        userService.crateUser(user);
        ResponseEntity<String> response = userService.loginUser(email, password);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
}