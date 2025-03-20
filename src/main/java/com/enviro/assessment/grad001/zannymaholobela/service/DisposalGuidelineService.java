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
        return disposalGuidelineRepository.findAll();
    }

    // Retrieve a disposal guideline by ID
    @Cacheable(value = "disposalGuideline", key = "#id")
    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    // Add a new disposal guideline
    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public DisposalGuideline addDisposalGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }

    // Update an existing disposal guideline
    @CacheEvict(value = {"disposalGuidelines", "disposalGuideline"}, allEntries = true)
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        return disposalGuidelineRepository.findById(id)
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
        if (disposalGuidelineRepository.existsById(id)) {
            disposalGuidelineRepository.deleteById(id);
        } else {
            throw new RuntimeException("Disposal guideline not found for ID: " + id);
        }
    }
}