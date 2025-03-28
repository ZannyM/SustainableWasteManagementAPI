package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.dto.ResponseMessage;
import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * This controller class handles administrative operations for waste categories,
 * such as creating, updating, and deleting categories.
 * It is intended for use by administrators only.
 */
@RestController
@RequestMapping("/api/admin/waste-categories")
public class AdminController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public AdminController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
    /**
     * Creates a new waste category.
     *
     * @param wasteCategory The waste category object to be created.
     * @return A ResponseEntity with a success message and HTTP status CREATED.
     */
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
    /**
     * Deletes an existing waste category.
     *
     * @param id The ID of the waste category to be deleted.
     * @return A ResponseEntity with a success or error message and the appropriate HTTP status code.
     */
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

    @DeleteMapping("/{id}/permanent")
    public ResponseEntity<ResponseMessage> permanentlyDeleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.hardDeleteWasteCategory(id);
        return new ResponseEntity<>(createResponse("Waste category permanently deleted"), HttpStatus.OK);
    }
}
