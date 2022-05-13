package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//creating table
@Entity
public class MealType {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealTypeId")
    private int mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    //getters and setters
    public int getMealId() {return mealId;
    }

    public void setMealId(int mealId) {this.mealId = mealId;
    }

    public String getName(MealType mealTypeObject) {return name;
    }

    public void setName(String name) {this.name = name;
    }

    public String getDescription() {return description;
    }

    public void setDescription(String description) {this.description = description;
    }

    //to string method
    @Override
    public String toString() {
        return "mealType{" +
                "mealId=" + mealId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
