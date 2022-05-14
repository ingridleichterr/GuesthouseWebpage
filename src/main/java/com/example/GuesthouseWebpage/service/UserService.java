package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.repository.UserRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private static EntityManager em;
    public UserService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //method list all users
    public List<User> listAllUsers() {
        return em.createQuery("Select n from User as n order by n.name asc")
                .getResultList();
    }

    //method save user
    public void saveUser(User user){
        try {
            em.getTransaction().begin();
            this.em.persist(user);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method count total users
    public long countUsers(){
        String sql = "SELECT count(userId) FROM User";
        return (long)em.createQuery(sql).getSingleResult();
    }

}
