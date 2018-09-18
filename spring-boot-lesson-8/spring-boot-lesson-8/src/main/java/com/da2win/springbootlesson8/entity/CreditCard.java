package com.da2win.springbootlesson8.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 信用卡实体对象
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String number;

    @Column(name = "reg_date")
    private Date registeredDate;

    @OneToOne(mappedBy = "creditCard", cascade = CascadeType.REMOVE)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
