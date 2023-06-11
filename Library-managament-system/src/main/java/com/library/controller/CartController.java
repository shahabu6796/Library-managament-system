package com.library.controller;

import com.library.entity.Book;
import com.library.entity.Cart;
import com.library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public void addItem(@RequestBody Cart cart){
        cartService.addItem(cart);
    }
    @DeleteMapping("/remove")
    public void removeItem(@RequestParam long bookId,@RequestParam long userId){
        cartService.removeItem(bookId,userId);
    }
    @GetMapping("/viewcart")
    public List<Book> viewYourCart(@RequestParam Long cartId){
       return cartService.getCartById(cartId);
    }
}
