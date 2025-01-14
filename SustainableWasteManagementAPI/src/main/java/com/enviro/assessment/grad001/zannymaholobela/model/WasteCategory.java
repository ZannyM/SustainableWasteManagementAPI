package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "waste_category")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
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
