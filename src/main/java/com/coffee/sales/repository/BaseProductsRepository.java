package com.coffee.sales.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.sales.entities.BaseProducts;

public interface BaseProductsRepository extends JpaRepository<BaseProducts, Integer>{

	
	List<BaseProducts>findByUserIdAndDeleted(int userId, LocalDateTime deleted );
}
