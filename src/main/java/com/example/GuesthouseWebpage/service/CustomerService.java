package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Customer;
import com.example.GuesthouseWebpage.repository.CustomerRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private static EntityManager em;
    public CustomerService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //method list all customers
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select n from Customer as n order by n.name asc")
                .getResultList();
    }

    //method save customer
    public void saveCustomer(Customer customer){
        try {
            em.getTransaction().begin();
            this.em.persist(customer);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method count total customers
    public long countCustomers(){
        String sql = "SELECT count(customerId) FROM Customer";
        return (long)em.createQuery(sql).getSingleResult();
    }

}
