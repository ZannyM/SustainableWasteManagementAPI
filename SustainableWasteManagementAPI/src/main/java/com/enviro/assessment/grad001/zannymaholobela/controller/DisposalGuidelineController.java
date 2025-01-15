package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.model.DisposalGuideline;
import com.enviro.assessment.grad001.zannymaholobela.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    // Get all disposal guidelines
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> guidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return new ResponseEntity<>(guidelines, HttpStatus.OK);
    }

    // Get a specific disposal guideline by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        return disposalGuidelineService.getDisposalGuidelineById(id)
                .map(guideline -> new ResponseEntity<>(guideline, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new disposal guideline
    @PostMapping
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@RequestBody DisposalGuideline guideline) {
        DisposalGuideline savedGuideline = disposalGuidelineService.addDisposalGuideline(guideline);
        return new ResponseEntity<>(savedGuideline, HttpStatus.CREATED);
    }

    // Update an existing disposal guideline
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline updatedGuideline) {
        try {
            DisposalGuideline updated = disposalGuidelineService.updateDisposalGuideline(id, updatedGuideline);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a disposal guideline
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        try {
            disposalGuidelineService.deleteDisposalGuideline(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
