package com.da2win.springbootlesson8.entity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class CustomerListener {

    @PrePersist
    public void prePersist(Object source) {
        System.out.println("@PrePersist : " + source);
    }

    @PostPersist
    public void postPersist(Object source) {
        System.out.println("@PostPersist : " + source);
    }
}
