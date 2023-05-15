package com.coffee.sales.repository;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.sales.entities.BaseUser;

public interface BaseUserRepository extends JpaRepository<BaseUser, Integer> {
    
    Optional<BaseUser>findByIdAndDeleted(int id, LocalDateTime Deleted);
	
	Optional<BaseUser>findByEmailAndDeleted(String email, LocalDateTime deleted);
	
	Optional<BaseUser> findById(Long id);

}
