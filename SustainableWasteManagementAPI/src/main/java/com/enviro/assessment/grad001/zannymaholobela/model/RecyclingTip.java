package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recycling_tip")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String recyclingTips;

    //Getters

    public Long getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }

    public String getRecyclingTips(){
        return recyclingTips;
    }
    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setRecyclingTips(String recyclingTips){
        this.recyclingTips = recyclingTips;
    }
}
