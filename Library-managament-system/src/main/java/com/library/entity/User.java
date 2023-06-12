package com.library.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userEmail;
    private  String password;
    // Example: One user can have many books
    @OneToMany(mappedBy = "user")
    private List<Cart> cartItems;

    // Example: One user can have many books
    @OneToMany(mappedBy = "user")
    private List<Book> books;
}
