package com.enviro.assessment.grad001.zannymaholobela.service;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import com.enviro.assessment.grad001.zannymaholobela.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecyclingTipService {
    private final RecyclingTipRepository recyclingTipRepository;

    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    public RecyclingTip getRecyclingTipById(Long id){
        return recyclingTipRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Recycling tip not found for ID: " + id));
    }
}
