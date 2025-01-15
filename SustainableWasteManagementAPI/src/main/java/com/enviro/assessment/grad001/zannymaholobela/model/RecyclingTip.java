package com.enviro.assessment.grad001.zannymaholobela.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recycling_tip")
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "tip", nullable = false)
    @NotBlank(message = "Recycling tip cannot be blank")
    @Size(min = 5, max = 250, message = "Recycling tip must be between 5 and 250 characters")
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
