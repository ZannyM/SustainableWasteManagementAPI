package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
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
@RequestMapping("/api/categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;
    //constructor parameter
    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
    //Get all wasteCategories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories(){
        List<WasteCategory> categories = wasteCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Get wasteCategory by ID
    @GetMapping("/{id}")
    public  ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id){
        Optional<WasteCategory> category = wasteCategoryService.getWasteCategoryById(id);
        return category.map(ResponseEntity::ok).orElseThrow(() ->new ResourceNotFoundException("WasteCategory not found with ID: " + id));
    }
    // Create a new WasteCategory
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Validated @RequestBody WasteCategory wasteCategory) {
        WasteCategory savedCategory = wasteCategoryService.saveCategory(wasteCategory);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
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
        return ResponseEntity.noContent().build();
    }

}
