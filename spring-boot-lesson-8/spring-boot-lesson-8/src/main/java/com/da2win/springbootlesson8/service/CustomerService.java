package com.da2win.springbootlesson8.service;

import com.da2win.springbootlesson8.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 客户服务
 */
@Service
@Transactional
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 添加客户
     * @param customer
     */
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }
}
