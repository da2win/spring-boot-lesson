package com.da2win.springbootlesson8.entity;

import com.da2win.springbootlesson8.entity.listener.CustomerListener;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AccessType(AccessType.Type.FIELD)
@Table(name = "customers")
@EntityListeners(value = CustomerListener.class)
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    private CreditCard creditCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private Collection<Book> books;

    @Column(length = 64)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", creditCard=" + creditCard +
                ", store=" + store +
                ", books=" + books +
                ", name='" + name + '\'' +
                '}';
    }
}
