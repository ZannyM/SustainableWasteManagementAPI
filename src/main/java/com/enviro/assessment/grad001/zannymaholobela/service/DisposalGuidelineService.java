package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.DisposalGuideline;
import com.enviro.assessment.grad001.zannymaholobela.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Service class for managing DisposalGuidelines entities.
 */
@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
    }

    // Retrieve all disposal guidelines
    @Cacheable("disposalGuidelines")
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findByActiveTrue();
    }

    // Retrieve a disposal guideline by ID
    @Cacheable(value = "disposalGuideline", key = "#id")
    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findByIdAndActiveTrue(id);
    }

    // Add a new disposal guideline
    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public DisposalGuideline addDisposalGuideline(DisposalGuideline guideline) {
        guideline.setActive(true);
        return disposalGuidelineRepository.save(guideline);
    }

    // Update an existing disposal guideline
    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        return disposalGuidelineRepository.findByIdAndActiveTrue(id)
                .map(existingGuideline -> {
                    existingGuideline.setWasteType(updatedGuideline.getWasteType());
                    existingGuideline.setDisposalMethod(updatedGuideline.getDisposalMethod());
                    existingGuideline.setInstructions(updatedGuideline.getInstructions());
                    existingGuideline.setHazardous(updatedGuideline.getHazardous());
                    return disposalGuidelineRepository.save(existingGuideline);
                }).orElseThrow(() -> new RuntimeException("Disposal guideline not found for ID: " + id));
    }

    // Delete a disposal guideline

    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public void deleteDisposalGuideline(Long id) {
        Optional<DisposalGuideline> guideline = disposalGuidelineRepository.findById(id);
        if (guideline.isPresent()) {
            DisposalGuideline guidelineToUpdate = guideline.get();
            guidelineToUpdate.setActive(false);
            disposalGuidelineRepository.save(guidelineToUpdate);
        } else {
            throw new RuntimeException("Disposal guideline not found for ID: " + id);
        }
    }
    // to restore functionality
    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public DisposalGuideline restoreDisposalGuideline(Long id) {
        Optional<DisposalGuideline> guideline = disposalGuidelineRepository.findById(id);
        if (guideline.isPresent()) {
            DisposalGuideline guidelineToRestore = guideline.get();
            guidelineToRestore.setActive(true);
            return disposalGuidelineRepository.save(guidelineToRestore);
        } else {
            throw new RuntimeException("Disposal guideline not found for ID: " + id);
        }
    }
}