package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 * Repository interface for RecyclingTip entity.
 */
@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    List<RecyclingTip> findByActiveTrue();

    Optional<RecyclingTip> findByIdAndActiveTrue(Long id);

    List<RecyclingTip> findByCategoryIdAndActiveTrue(Long categoryId);
}
