package com.death.spring.dao;

import com.death.spring.model.Book;

import java.util.List;

public interface BookDAO {
    //save book
    long saveRecord(Book book);

    //get single book
    Book getBook(long id);

    //get all books
    List<Book> getAllBooks();

    //update record
    void update(long id, Book book);

    //delete a book
    void deleteBook(long id);
}
