package com.library.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Tbook")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId = 0L;
    private String bookName = "";
    private Double bookPrice = 0.0;
    private String author = "";
    // Example: Many books can be borrowed by one user


    @OneToMany(mappedBy = "book")
    private List<Cart> cartItems;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
