package com.da2win.springbootlesson18.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Darwin
 * @Date 2018/11/7 11:16
 */
@ConfigurationProperties("book")
public class Book {

    private String isbn;
    private String name;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
