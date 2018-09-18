package com.da2win.springbootlesson8.entity;


import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Inheritance
@Entity
public class VipCustomer extends Customer {

    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
