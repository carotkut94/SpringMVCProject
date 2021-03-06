package com.death.spring.dao;

import com.death.spring.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public long saveBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    public Book getBook(long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public List<Book> getAllBooks() {
        List<Book> books = sessionFactory
                .getCurrentSession()
                .createQuery("from Book")
                .list();
        return books;
    }

    public void update(long id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book oldBook = session.byId(Book.class).load(id);
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        session.flush();
    }

    public void deleteBook(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        session.delete(book);
    }
}
