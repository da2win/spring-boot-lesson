package com.da2win.springbootlesson18.controller;

import com.da2win.springbootlesson18.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Darwin
 * @Date 2018/11/7 11:16
 */
@RestController
@EnableConfigurationProperties(Book.class)
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("book")
    public Book book() {

        return book;
    }
}
