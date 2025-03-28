package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;
//Using category in a service
/**
 * Service class for managing WasteCategory entities.
 */
@Service
public class WasteCategoryService {
    private final WasteCategoryRepository wasteCategoryRepository;

    //Constructor
    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }
    /**
     * Get all the WasteCategories.
     *
     * @return the list of entities
     */
    @Cacheable("wasteCategories")
    public List<WasteCategory> getAllCategories(){
        return wasteCategoryRepository.findByActiveTrue();
    }
    /**
     * Find one WasteCategory by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    @Cacheable(value = "wasteCategory", key = "#id")
    public Optional<WasteCategory> getWasteCategoryById(Long id){
        return wasteCategoryRepository.findByIdAndActiveTrue(id);
    }
    /**
     * Save a WasteCategory.
     *
     * @param category the entity to save
     * @return the persisted entity
     */
    @CacheEvict(value = {"wasteCategories", "wasteCategory"}, allEntries = true)
    public WasteCategory saveCategory(WasteCategory category){
        return wasteCategoryRepository.save(category);
    }

    //Find waste category by type
    @Cacheable(value = "wasteCategory", key = "#name")
    public Optional<WasteCategory> getCategoriesByName(String name){
        return wasteCategoryRepository.findByName(name);
    }
    /**
     * Update a WasteCategory.
     *
     * @param id the ID of the entity
     * @param updatedWasteCategory the updated entity
     * @return the updated entity
     */
    @CacheEvict(value = {"wasteCategories", "wasteCategory"}, allEntries = true)
    public Optional<WasteCategory> updateWasteCategory(Long id, WasteCategory updatedWasteCategory){
        return Optional.ofNullable(wasteCategoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setName(updatedWasteCategory.getName());
            existingCategory.setDescription(updatedWasteCategory.getDescription());
//            existingCategory.setType(updatedWasteCategory.getType());
            existingCategory.setName(updatedWasteCategory.getName());
            return wasteCategoryRepository.save(existingCategory);
        }).orElseThrow(() -> new RuntimeException("WasteCategory not found with ID: " + id)));
    }
    /**
     * Delete the product by ID.
     *
     * @param id the ID of the entity
     */
    @CacheEvict(value = {"wasteCategories", "wasteCategory"}, allEntries = true)
    public void deleteWasteCategory(Long id) {
        Optional<WasteCategory> category = wasteCategoryRepository.findById(id);
        if (category.isPresent()) {
            WasteCategory wasteCategoryToUpdate = category.get();
            wasteCategoryToUpdate.setActive(false);
            wasteCategoryRepository.save(wasteCategoryToUpdate);
        } else {
            throw new RuntimeException("WasteCategory not found with ID: " + id);
        }
    }

    @CacheEvict(value = {"wasteCategories", "wasteCategory"}, allEntries = true)
    public void createWasteCategory(WasteCategory wasteCategory) {
        wasteCategoryRepository.save(wasteCategory);
    }
    // restore
    public WasteCategory restoreWasteCategory(Long id) {
        Optional<WasteCategory> category = wasteCategoryRepository.findById(id);
        if (category.isPresent()) {
            WasteCategory wasteCategoryToRestore = category.get();
            wasteCategoryToRestore.setActive(true);
            return wasteCategoryRepository.save(wasteCategoryToRestore);
        } else {
            throw new RuntimeException("WasteCategory not found with ID: " + id);
        }
    }
    //for admins to permanently delete records
    public void hardDeleteWasteCategory(Long id) {
        if (wasteCategoryRepository.existsById(id)) {
            wasteCategoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("WasteCategory not found with ID: " + id);
        }
    }
}