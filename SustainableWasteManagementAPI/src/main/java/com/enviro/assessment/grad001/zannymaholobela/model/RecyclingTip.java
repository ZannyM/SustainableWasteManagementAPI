package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recycling_tip")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private long category;

//    @Column(name = "recycling_tips", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'default value'")
    @Column(name = "tip")
    private String tip;

    //Getters

    public Long getId(){
        return id;
    }

    public Long getCategory(){
        return category;
    }

    public String getTip(){
        return tip;
    }
    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Long category){
        this.category = category;
    }

    public void setRecyclingTips(String tip){
        this.tip = tip;
    }
}
