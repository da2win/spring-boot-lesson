package com.da2win.springbootlesson8.entity;

import org.springframework.data.annotation.AccessType;

import javax.persistence.*;

@Entity
@AccessType(AccessType.Type.FIELD)
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private CreditCard creditCard;

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
}
