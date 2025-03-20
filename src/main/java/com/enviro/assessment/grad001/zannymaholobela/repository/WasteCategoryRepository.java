package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for WasteCategory entity.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    //Find wastecategory by name
    Optional<WasteCategory> findByName(String namevalue);

}





