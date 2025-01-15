package com.enviro.assessment.grad001.zannymaholobela.repository;

import com.enviro.assessment.grad001.zannymaholobela.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for DisposalGuideline entity.
 */
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

}
