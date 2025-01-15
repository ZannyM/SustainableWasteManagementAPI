package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
/**
 * This class represents a Waste Category entity in the database.
 * A Waste Category defines a type of waste material (e.g., Paper, Plastic, Glass).
 */
@Entity
@Table(name = "waste_category")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use auto increment to update each row

    private Long id;

    @Column(name = "name",nullable = false, unique = true)
    @NotBlank(message = "Category name cannot be blank")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")

    private String name;

    @Column(nullable = false)
    private String description;


    //default constructor (required by JPA)
    public WasteCategory(){

    }

    //Getters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    //Setters

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
