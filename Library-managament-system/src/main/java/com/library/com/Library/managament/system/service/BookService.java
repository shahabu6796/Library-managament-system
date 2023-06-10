package com.library.com.Library.managament.system.service;

import com.library.com.Library.managament.system.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseEntity<String> saveNewBook(Book book);
    boolean isBookAlreadyExists(String bookName,String author);

    ResponseEntity<String> saveAllNewBooks(List<Book> books);

    Optional<Book> getBookByBookName(String bookName);
}
