package com.da2win.springbootlesson9.controller;

import com.da2win.springbootlesson9.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class BookController {
    @Autowired
    @Qualifier("bookRepository")
    private PagingAndSortingRepository<Book, String> bookRepository;

    @GetMapping(value = "/book/{id}")
    public Book getBook(@PathVariable String id) {
        Book book = bookRepository.findOne(id);
        return book;
    }

    @PostMapping("/book/{id}")
    public Book publishBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        book.setPublishedDate(new Date(System.currentTimeMillis()));
        bookRepository.save(book);
        return book;
    }

}
