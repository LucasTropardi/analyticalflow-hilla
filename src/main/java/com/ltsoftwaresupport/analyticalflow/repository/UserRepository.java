package com.ltsoftwaresupport.analyticalflow.repository;

import com.ltsoftwaresupport.analyticalflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lucas Tropardi
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
