package com.death.spring.controller;

import com.death.spring.model.Book;
import com.death.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    //save a book
    @PostMapping("/api/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        long id = bookService.saveBook(book);
        return ResponseEntity.ok().body("Book created with id : "+id);
    }

}
