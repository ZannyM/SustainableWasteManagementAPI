package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disposal_guideline")
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "waste_type", nullable = false)
    private String wasteType;

    @Column(name = "disposal_method", nullable = false)
    private String disposalMethod;

    @Column(name = "instructions", nullable = false)
    private String instructions;

    @Column(name = "hazardous", nullable = false)
    private Boolean hazardous;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Boolean getHazardous() {
        return hazardous;
    }

    public void setHazardous(Boolean hazardous) {
        this.hazardous = hazardous;
    }
}
