package com.death.spring.controller;

import com.death.spring.model.Book;
import com.death.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    //get a single book
    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable("id") long id){
        Book book = bookService.getBook(id);
        return ResponseEntity.ok().body(book);
    }

    //update a book
    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody Book book){
        bookService.update(id, book);
        return ResponseEntity.ok().body("Book updated");
    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().body("Book deleted!");
    }
}
