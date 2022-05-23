package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Extras {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private boolean isActive;


    @OneToMany
    private List<ExtrasImage> extrasImages;

}
