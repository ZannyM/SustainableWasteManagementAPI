package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for RecyclingTip entity.
 */
@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    //query methods added here

}
