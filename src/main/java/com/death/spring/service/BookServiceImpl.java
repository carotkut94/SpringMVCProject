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

    @Transactional
    public Book getBook(long id) {
        return bookDAO.getBook(id);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Transactional
    public void update(long id, Book book) {
        bookDAO.update(id, book);
    }

    @Transactional
    public void deleteBook(long id) {
        bookDAO.deleteBook(id);
    }
}
