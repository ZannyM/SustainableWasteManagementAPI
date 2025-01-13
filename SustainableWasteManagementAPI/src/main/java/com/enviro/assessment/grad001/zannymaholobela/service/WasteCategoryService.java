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
     * Get one WasteCategory by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
//    public Optional<WasteCategory> getWasteCategoryById(Long id){
//        return WasteCategoryRepository.findById(id);
//    }
    /**
     * Update a WasteCategory.
     *
     * @param id the ID of the entity
     * @param updatedProduct the updated entity
     * @return the updated entity
     */
//    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedWasteCategory){
//        Optional<WasteCategory> existingWasteCategory = WasteCategoryRepository.findById(id);
//        if(existingWasteCategory.isPresent()){
//            WasteCategory wasteCategory = existingWasteCategory.get();
//            WasteCategory.setName(updatedWasteCategory.getName());
//            WasteCategory.setId(updatedWasteCategory.getId());
//            WasteCategory.setDescription(updatedWasteCategory.getDescription());
//            return WasteCategoryRepository.save(wasteCategory);
//        }else {
//            throw new RuntimeException("WasteCategory not found!")
//        }
//    }
    /**
     * Delete the product by ID.
     *
     * @param id the ID of the entity
     */
//    public void deleteWasteCategory(Long id){
//        WasteCategoryRepository.deleteById(id);
//    }

}
