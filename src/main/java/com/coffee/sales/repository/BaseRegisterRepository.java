package com.coffee.sales.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.sales.entities.BaseRegister;

public interface BaseRegisterRepository extends JpaRepository<BaseRegister, Integer> {

	List<BaseRegister>findByCustomerIdAndDeleted(int customerId ,LocalDateTime deleted );

	
	
}
