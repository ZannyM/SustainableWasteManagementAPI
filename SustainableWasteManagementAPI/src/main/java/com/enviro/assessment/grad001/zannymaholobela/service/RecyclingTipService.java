package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import com.enviro.assessment.grad001.zannymaholobela.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;

    // Constructor
    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    // Get all recycling tips
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    // Get recycling tip by ID
    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id);
    }

    /**
     * Save a RecyclingTip.
     *
     * @param recyclingTip the entity to save
     * @return the persisted entity
     */
    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip); // Correct usage
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        return recyclingTipRepository.findById(id)
                .map(existingTip -> {
                    existingTip.setCategoryId(updatedTip.getCategoryId());
                    existingTip.setRecyclingTips(updatedTip.getTip());
                    return recyclingTipRepository.save(existingTip);
                }).orElseThrow(() -> new RuntimeException("RecyclingTip not found with ID: " + id));
    }

    public void deleteRecyclingTip(Long id) {
        if (recyclingTipRepository.existsById(id)) {
            recyclingTipRepository.deleteById(id);
        } else {
            throw new RuntimeException("RecyclingTip not found with ID: " + id);
        }
    }

    // Get a random recycling tip
    public RecyclingTip getRandomRecyclingTip() {
        List<RecyclingTip> allTips = recyclingTipRepository.findAll();
        if (!allTips.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(allTips.size());
            return allTips.get(randomIndex);
        } else {
            throw new RuntimeException("No recycling tips available.");
        }
    }
}
