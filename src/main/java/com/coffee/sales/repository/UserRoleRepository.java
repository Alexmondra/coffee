package com.coffee.sales.repository;

import java.util.List;
import java.util.Optional;

import com.coffee.sales.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer> {
	
	Optional<UserRoles> findByUserIdAndRoleId(int userId, int roleId);
	
	List<UserRoles> findByUserId(int userId);
	
	

}
