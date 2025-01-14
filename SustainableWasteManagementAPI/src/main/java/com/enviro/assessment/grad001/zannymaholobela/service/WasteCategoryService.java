package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<WasteCategory> getAllCategories(){
        return wasteCategoryRepository.findAll();
    }
    /**
     * Save a WasteCategory.
     *
     * @param category the entity to save
     * @return the persisted entity
     */
    public WasteCategory saveCategory(WasteCategory category){
        return wasteCategoryRepository.save(category);
    }
    /**
     * Find one WasteCategory by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<WasteCategory> getWasteCategoryById(Long id){
        return wasteCategoryRepository.findById(id);
    }

    //Find waste category by type
    public List<WasteCategory> getCategoriesByName(String name){
        return wasteCategoryRepository.findByName(name);
    }
    /**
     * Update a WasteCategory.
     *
     * @param id the ID of the entity
     * @param updatedWasteCategory the updated entity
     * @return the updated entity
     */
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
    public void deleteWasteCategory(Long id){
        if(wasteCategoryRepository.existsById(id)){
            wasteCategoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("WasteCategory not found with ID: " + id);
        }
    }

}
