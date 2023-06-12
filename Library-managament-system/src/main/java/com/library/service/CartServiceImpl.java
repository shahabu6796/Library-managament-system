package com.library.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.Cart;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.repository.CartRepository;
import com.library.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addToCart(Long userId, Long bookId)
    {
        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (user != null && book != null && book.getUser() == null)
        {
            Cart cartItem = new Cart();
            cartItem.setUser(user);
            cartItem.setBook(book);
            cartItem.setBorrowedAt(LocalDateTime.now());
            cartRepository.save(cartItem);
        }
    }

    @Override
    public void removeFromCart(Long cartId)
    {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void checkoutCart(Long cartId)
    {
        Cart cartItem = cartRepository.findById(cartId).orElse(null);

        if (cartItem != null && cartItem.getReturnedAt() == null)
        {
            cartItem.setReturnedAt(LocalDateTime.now());
            cartRepository.save(cartItem);
        }
    }

    @Override
    public void returnBook(Long cartId)
    {
        Cart cartItem = cartRepository.findById(cartId).orElse(null);

        if (cartItem != null)
        {
            cartItem.setReturnedAt(LocalDateTime.now());
            cartRepository.save(cartItem);
        }
    }

    @Override
    public BigDecimal calculateLateFine(Long cartId)
    {
        Cart cartItem = cartRepository.findById(cartId).orElse(null);

        if (cartItem != null && cartItem.getReturnedAt() != null)
        {
            LocalDateTime dueDate = cartItem.getBorrowedAt().plusDays(7);
            LocalDateTime returnedDate = cartItem.getReturnedAt();
            if (returnedDate.isAfter(dueDate))
            {
                long daysLate = ChronoUnit.DAYS.between(dueDate, returnedDate);
                BigDecimal lateFine = BigDecimal.valueOf(daysLate).multiply(BigDecimal.valueOf(5)); // 5 repuees per day late
                return lateFine;
            }
        }

        return BigDecimal.ZERO;
    }
}
