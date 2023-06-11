package com.library.service;

import com.library.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseEntity<String> saveNewBook(Book book);
    boolean isBookAlreadyExists(String bookName,String author);

    ResponseEntity<String> saveAllNewBooks(List<Book> books);

    Optional<Book> getBookByBookName(String bookName);
    Optional<Book> getByBookNameAndAuthor(String bookName,String author);

    Optional<Book> getBookByBookId(Long bookId);
}
