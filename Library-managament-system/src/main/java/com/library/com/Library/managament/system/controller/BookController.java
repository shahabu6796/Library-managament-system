package com.library.com.Library.managament.system.controller;

import com.library.com.Library.managament.system.entity.Book;
import com.library.com.Library.managament.system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public ResponseEntity<String> addBookRecord(@RequestBody Book book) {
        return bookService.saveNewBook(book);
    }

    @PostMapping("/addbooks")
    public ResponseEntity<String> addBooksRecord(@RequestBody List<Book> books) {
        return bookService.saveAllNewBooks(books);
    }

    @GetMapping("/findbybookname")
    public ResponseEntity<Book> getBookByName(@RequestParam String bookName) {
        Optional<Book> book = bookService.getBookByBookName(bookName);
        if (book.isPresent()) {
            return ResponseEntity.of(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
