package com.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.library.entity.User;
import com.library.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest
{

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("create user")
    void testCrateUser()
    {
        String email = "test";
        User user = User.builder().userEmail(email).build();
        // Mocking the isUserAlreadyExists method to return true
        Mockito.when(userService.isUserAlreadyExists(email)).thenReturn(Optional.empty());
        var responseEntity = userService.crateUser(user);
        // Verify that the user is saved and response status is OK
        Mockito.verify(userRepository).save(user);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User Account has been created successfully..", responseEntity.getBody());
    }

    @Test
    @DisplayName("login")
    void testLoginUser()
    {
        String email = "test";
        String password = "test1";
        User user = User.builder().userEmail(email).password(password).build();
        Mockito.when(userRepository.findByUserEmailAndPassword(email, password)).thenReturn(user);
        ResponseEntity<String> response = userService.loginUser(email, password);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testIsUserAlreadyExists()
    {
        Mockito.when(userRepository.findByUserEmail("shahab@123")).thenReturn(Optional.empty());
        var isExists = userService.isUserAlreadyExists("shahab@123");
        assertEquals(false,isExists.isPresent());
    }
}