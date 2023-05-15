package com.coffee.sales.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffee.sales.entities.BaseRole;


@Repository
public interface BaseRoleRepository extends JpaRepository<BaseRole , Integer> {
	
	Optional<BaseRole>findById(int id);
	
	BaseRole findByName(String name);

}
