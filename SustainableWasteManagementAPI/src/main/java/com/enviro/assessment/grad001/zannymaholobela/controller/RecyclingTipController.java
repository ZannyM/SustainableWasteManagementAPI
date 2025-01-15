package com.enviro.assessment.grad001.zannymaholobela.controller;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import com.enviro.assessment.grad001.zannymaholobela.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecyclingTipController {
    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }
    //Get all recycling tips
    @GetMapping("/recycling-tip")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        List<RecyclingTip> tips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(tips);
    }

    //Get a specific recycling tip by ID
    @GetMapping("/recycling-tip/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id){
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return ResponseEntity.ok(recyclingTip);
    }

}
