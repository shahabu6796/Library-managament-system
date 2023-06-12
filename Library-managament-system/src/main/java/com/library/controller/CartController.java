package com.library.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController
{
    @Autowired
    private CartService cartService;

    @PostMapping("/add/{userId}/{bookId}")
    public void addToCart(@PathVariable Long userId, @PathVariable Long bookId)
    {
        cartService.addToCart(userId, bookId);
    }

    @PostMapping("/remove/{cartId}")
    public void removeFromCart(@PathVariable Long cartId)
    {
        cartService.removeFromCart(cartId);
    }

    @PostMapping("/checkout/{cartId}")
    public void checkoutCart(@PathVariable Long cartId)
    {
        cartService.checkoutCart(cartId);
    }

    @PostMapping("/return/{cartId}")
    public void returnBook(@PathVariable Long cartId)
    {
        cartService.returnBook(cartId);
    }

    @GetMapping("/latefine/{cartId}")
    public BigDecimal calculateLateFine(@PathVariable Long cartId)
    {
        return cartService.calculateLateFine(cartId);
    }
}
