package com.ltsoftwaresupport.analyticalflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltsoftwaresupport.analyticalflow.model.Author;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
