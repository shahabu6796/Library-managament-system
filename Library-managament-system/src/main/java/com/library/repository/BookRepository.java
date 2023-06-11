package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByBookNameAndAuthor(String bookName,String author);
    Optional<Book> findByBookName(String bookName);
}
