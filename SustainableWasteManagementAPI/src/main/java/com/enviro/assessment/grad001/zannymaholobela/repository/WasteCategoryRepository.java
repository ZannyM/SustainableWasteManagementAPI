package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    //query methods implemented here
    List<WasteCategory> findByType(String type);

}
