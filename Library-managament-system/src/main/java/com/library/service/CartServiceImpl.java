package com.library.service;

import com.library.entity.Book;
import com.library.entity.Cart;
import com.library.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<String> addItem(Cart cart) {
        //set current date of system
        cart.setAllotDate(LocalDateTime.now());
        cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.OK).body("Book added successfully..");
    }

    @Override
    public ResponseEntity<String> removeItem(long bookId, long userId) {
//        cartRepository.deleteById(new CartKey(userId, bookId));
        return ResponseEntity.status(HttpStatus.OK).body("Book removed successfully..");
    }

    @Override
    public List<Book> getCartById(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Book> book = bookService.getBookByBookId(cart.get().getBookId());
        return List.of(book.get());
    }
}
