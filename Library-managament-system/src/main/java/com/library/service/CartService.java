package com.library.service;

import com.library.entity.Book;
import com.library.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {
    ResponseEntity<String> addItem(Cart cart);

    ResponseEntity<String> removeItem(long bookId, long userId);

    List<Book> getCartById(Long cartId);
}
