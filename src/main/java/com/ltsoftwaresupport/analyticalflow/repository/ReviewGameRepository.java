package com.ltsoftwaresupport.analyticalflow.repository;

import com.ltsoftwaresupport.analyticalflow.model.ReviewGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Tropardi
 * 27 de Mai. de 2024
 */
@Repository
public interface ReviewGameRepository extends JpaRepository<ReviewGame, Long> {
}
