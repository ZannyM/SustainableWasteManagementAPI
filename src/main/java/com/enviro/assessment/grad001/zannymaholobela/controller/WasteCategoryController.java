package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.zannymaholobela.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing WasteCategory.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;  // Inject the repository

    //constructor parameter
    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    //Get all wasteCategories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        List<WasteCategory> categories = wasteCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Get wasteCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = wasteCategoryService.getWasteCategoryById(id);
        return category.map(ResponseEntity::ok).orElseThrow(() -> new ResourceNotFoundException("WasteCategory not found with ID: " + id));
    }

    // Create a new WasteCategory
    @PostMapping
    public ResponseEntity<?> createCategory(@Validated @RequestBody WasteCategory wasteCategory) {
        // Ensure that the id is not passed in the request body
        wasteCategory.setId(null); // Ensure the id is null for new records

        // Check if a category with the same name already exists
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findByName(wasteCategory.getName());
        if (existingCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Category with the same name already exists.");
        }

        WasteCategory savedCategory = wasteCategoryService.saveCategory(wasteCategory);
//        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    // Update an existing WasteCategory
    @PutMapping("/{id}")
    public ResponseEntity<Optional<WasteCategory>> updateCategory(
            @PathVariable Long id,
            @Validated @RequestBody WasteCategory updatedCategory) {
        Optional<WasteCategory> category = wasteCategoryService.updateWasteCategory(id, updatedCategory);
        return ResponseEntity.ok(category);
    }

    // Delete a WasteCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.ok().build();
    }

    //restore a waste category
    @PostMapping("/{id}/restore")
    public ResponseEntity<WasteCategory> restoreCategory(@PathVariable Long id) {
        WasteCategory restored = wasteCategoryService.restoreWasteCategory(id);
        return ResponseEntity.ok(restored);
    }
}