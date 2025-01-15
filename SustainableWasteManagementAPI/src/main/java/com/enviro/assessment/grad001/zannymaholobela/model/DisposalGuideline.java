package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "disposal_guideline")
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "guideline")
    private String guideline;

    //Getters

    public Long getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }
    public String getGuideline(){
        return guideline;
    }
    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setGuideline(String guideline){
            this.guideline = guideline;
    }
}
