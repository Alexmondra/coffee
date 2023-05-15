package com.coffee.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.sales.DTO.CustomersDTO;
import com.coffee.sales.service.BaseCustomersService;
import com.coffee.sales.auth.jwt.JwtUser;
import com.coffee.sales.entities.BaseCustomers;
import com.coffee.sales.entities.BaseRole;

@RestController
@RequestMapping("v1/api/customers/")

public class CustomerController {
	@Autowired
	private BaseCustomersService customersService;
	
	
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('"+BaseRole.ROLE_USER+"')")
	public ResponseEntity<List<BaseCustomers>> getAllCustomers(){
		List<BaseCustomers> clientela = customersService.getAllCustomers();
		return ResponseEntity.ok(clientela);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CustomersDTO> addcustomer(@RequestBody CustomersDTO customersDTO ) {
		return ResponseEntity.ok(customersService.addcustomer(customersDTO ));
	}
	
	

	
	

}
