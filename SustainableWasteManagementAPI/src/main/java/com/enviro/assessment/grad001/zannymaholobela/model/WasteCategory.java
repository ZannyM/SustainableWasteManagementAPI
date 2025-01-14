package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String type; //repository query
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

    public String getType(){
        return type;
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

    public void setType(String type){
        this.type = type;
    }

}
