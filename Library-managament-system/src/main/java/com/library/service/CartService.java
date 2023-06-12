package com.library.service;

import com.library.entity.Book;
import com.library.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    void addToCart(Long userId, Long bookId);
    void removeFromCart(Long cartId);
    void checkoutCart(Long cartId);
    void returnBook(Long cartId);
    BigDecimal calculateLateFine(Long cartId);
}
