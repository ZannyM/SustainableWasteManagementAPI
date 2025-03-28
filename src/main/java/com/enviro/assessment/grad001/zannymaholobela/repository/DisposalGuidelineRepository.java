package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 * Repository interface for DisposalGuideline entity.
 */
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
   //methods for finding only active records
   List<DisposalGuideline> findByActiveTrue();

    Optional<DisposalGuideline> findByIdAndActiveTrue(Long id);

    List<DisposalGuideline> findByWasteTypeAndActiveTrue(String wasteType);
}
