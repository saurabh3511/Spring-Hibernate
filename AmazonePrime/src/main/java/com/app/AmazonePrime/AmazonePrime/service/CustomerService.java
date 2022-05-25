package com.app.AmazonePrime.AmazonePrime.service;

import com.app.AmazonePrime.AmazonePrime.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(int id);

    public void save(Customer customer);

    public void deleteById(int id);

    public boolean findByEmailId(Customer c);

}
