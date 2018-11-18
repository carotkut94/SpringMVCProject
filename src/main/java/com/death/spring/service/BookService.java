package com.death.spring.service;

import com.death.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    //save book
    long saveBook(Book book);

    //get single book
    Book getBook(long id);

    //get all books
    List<Book> getAllBooks();

    //update record
    void update(long id, Book book);

    //delete a book
    void deleteBook(long id);
}
