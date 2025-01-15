package com.enviro.assessment.grad001.zannymaholobela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This class represents a Disposal Guideline entity in the database.
 * A Disposal Guideline provides information on how to properly dispose of a specific waste type.
 */
@Entity
@Table(name = "disposal_guideline")
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "waste_type", nullable = false)
    @NotBlank(message = "Waste type cannot be blank")
    @Size(min = 2, max = 100, message = "Waste type must be between 2 and 100 characters")
    private String wasteType;

    @Column(name = "disposal_method", nullable = false)
    @NotBlank(message = "Disposal method cannot be blank")
    private String disposalMethod;

    @Column(name = "instructions", nullable = false)
    @NotBlank(message = "Instructions cannot be blank")
    private String instructions;

    @Column(name = "hazardous", nullable = false)
    @NotNull(message = "Hazardous field must be specified")
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
