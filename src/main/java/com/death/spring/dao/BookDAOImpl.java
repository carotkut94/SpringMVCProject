package com.death.spring.dao;

import com.death.spring.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public long saveRecord(Book book) {
        return 0;
    }

    public Book getBook(long id) {
        return null;
    }

    public List<Book> getAllBooks() {
        List<Book> books = sessionFactory
                .getCurrentSession()
                .createQuery("from Book")
                .list();
        return books;
    }

    public void update(long id, Book book) {

    }

    public void deleteBook(long id) {

    }
}
