package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.dto.ResponseMessage;
import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/waste-categories")
public class AdminController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public AdminController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    // POST: Create a new waste category
    @PostMapping
    public ResponseEntity<ResponseMessage> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        wasteCategoryService.createWasteCategory(wasteCategory);
        return new ResponseEntity<>(createResponse("Waste category created successfully"), HttpStatus.CREATED);
    }

    // PUT: Update an existing waste category
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory updatedCategory) {
        try {
            wasteCategoryService.updateWasteCategory(id, updatedCategory);
            return new ResponseEntity<>(createResponse("Waste category updated successfully"), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(createResponse("Waste category not found"), HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Delete a waste category
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteWasteCategory(@PathVariable Long id) {
        try {
            wasteCategoryService.deleteWasteCategory(id);
            return new ResponseEntity<>(createResponse("Waste category deleted successfully"), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(createResponse("Waste category not found"), HttpStatus.NOT_FOUND);
        }
    }

    // Helper method to create a JSON response
    private ResponseMessage createResponse(String message) {
        return new ResponseMessage(message);
    }
}
