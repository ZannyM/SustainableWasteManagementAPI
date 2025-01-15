package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import com.enviro.assessment.grad001.zannymaholobela.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    // Get all recycling tips
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> tips = recyclingTipService.getAllRecyclingTips();
        return new ResponseEntity<>(tips, HttpStatus.OK);
    }

    // Get a specific recycling tip by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return recyclingTip
                .map(tip -> new ResponseEntity<>(tip, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new recycling tip
    @PostMapping
    public ResponseEntity<RecyclingTip> addRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip savedTip = recyclingTipService.saveRecyclingTip(recyclingTip);
        return new ResponseEntity<>(savedTip, HttpStatus.CREATED);
    }

    // Update an existing recycling tip
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip recyclingTip) {
        try {
            RecyclingTip updatedTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
            return new ResponseEntity<>(updatedTip, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a recycling tip by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        try {
            recyclingTipService.deleteRecyclingTip(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
