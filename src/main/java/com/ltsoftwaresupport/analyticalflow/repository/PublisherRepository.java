package com.ltsoftwaresupport.analyticalflow.repository;

import com.ltsoftwaresupport.analyticalflow.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
