package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.service.WasteCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;
    //constructor parameter
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
    @GetMapping
    public List<WasteCategory> getAllCategories(){
        return wasteCategoryService.getAllCategories();
    }
//    @PostMapping
//    public WasteCategory addCategory(@RequestBody WasteCategory category){
//        return WasteCategoryService.saveCategory(category);
   // }
}
