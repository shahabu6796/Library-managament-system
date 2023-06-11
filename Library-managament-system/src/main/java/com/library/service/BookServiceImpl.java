package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<String> saveNewBook(Book book) {
        // validate for mandatory check
        if (!isBookAlreadyExists(book.getBookName(), book.getAuthor())) {
            bookRepository.save(book);
            return ResponseEntity.status(HttpStatus.OK).body("Book details added successfully..");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book record already exists..");
        }
    }

    @Override
    public boolean isBookAlreadyExists(String bookName, String author) {
        return bookRepository.findByBookNameAndAuthor(bookName, author).isPresent();
    }

    @Override
    public ResponseEntity<String> saveAllNewBooks(List<Book> books) {
        List<Book> bookToBeSaved = new ArrayList<>();
        List<Book> alreadyExistsBooks = new ArrayList<>();
        for (Book book : books) {
            if (!isBookAlreadyExists(book.getBookName(), book.getAuthor())) {
                bookToBeSaved.add(book);
            } else {
                alreadyExistsBooks.add(book);
            }
        }
        bookRepository.saveAll(bookToBeSaved);
        if (alreadyExistsBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("All Books details saved successfully..");
        } else {
            if (books.size() == alreadyExistsBooks.size()) {
                return ResponseEntity.status(HttpStatus.OK).body("All Books details already exists..");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("some books details are saved successfully and some details already exists.." + alreadyExistsBooks);
            }
        }
    }

    @Override
    public Optional<Book> getBookByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }
}
