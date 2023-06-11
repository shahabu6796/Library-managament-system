package com.library.repository;

import com.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmailAndPassword(String email, String password);
    Optional<User> findByUserEmail(String userEmail);
}
