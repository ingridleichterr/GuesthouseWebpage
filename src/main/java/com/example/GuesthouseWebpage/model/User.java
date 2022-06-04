package com.example.GuesthouseWebpage.model;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //as username
    private String email;

    private String password;

    private String name;

    private String phoneNumber;

    private LocalDate registrationDate;

    private boolean isActive;

    @OneToOne(cascade = CascadeType.MERGE)
    private Authority authority;

}
