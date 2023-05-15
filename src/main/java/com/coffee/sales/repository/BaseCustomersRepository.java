package com.coffee.sales.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.sales.entities.BaseCustomers;

public interface BaseCustomersRepository extends JpaRepository<BaseCustomers, Integer> {
	
    Optional<BaseCustomers>findByIdAndDeleted(int id, LocalDateTime Deleted);
    
	Optional<BaseCustomers>findByEmailAndDeleted(String email, LocalDateTime deleted);
	
	//Optional<BaseCustomers>findByNameAndDeleted(String name, LocalDateTime deleted);
	
	List<BaseCustomers>findByBaseUserIdAndDeleted(int baseClientesId ,LocalDateTime deleted );


}
