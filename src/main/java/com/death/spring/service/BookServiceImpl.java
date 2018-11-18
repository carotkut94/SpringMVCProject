package com.death.spring.service;

import com.death.spring.dao.BookDAO;
import com.death.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public long saveBook(Book book) {
        return bookDAO.saveBook(book);
    }

    public Book getBook(long id) {
        return null;
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void update(long id, Book book) {

    }

    public void deleteBook(long id) {

    }
}
