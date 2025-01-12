package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//Using category in a service
@Service
public class WasteCategoryService {
    private final WasteCategoryRepository wasteCategoryRepository;

    //Constructor
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }
    public List<WasteCategory> getAllCategories(){
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory saveCategory(WasteCategory category){
        return wasteCategoryRepository.save(category);
    }
}
