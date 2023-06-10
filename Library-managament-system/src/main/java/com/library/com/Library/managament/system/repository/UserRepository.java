package com.library.com.Library.managament.system.repository;

import com.library.com.Library.managament.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmailAndPassword(String email, String password);
}
