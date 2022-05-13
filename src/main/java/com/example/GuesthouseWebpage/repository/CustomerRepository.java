package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public List<Customer> listAllCustomers();


}
