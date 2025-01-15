package com.enviro.assessment.grad001.zannymaholobela.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recycling_tip")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

//    @Column(name = "recycling_tips", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'default value'")
    @Column(name = "tip")
    private String tip;

    @Transient
    private String categoryName;

    //Getters

    public Long getId(){
        return id;
    }

    public String getCategory(){
        return categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTip(){
        return tip;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryId(Long category){
        this.categoryId = category;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setRecyclingTips(String tip){
        this.tip = tip;
    }
}
