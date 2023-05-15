package com.coffee.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.sales.DTO.RegisterDTO;
import com.coffee.sales.entities.BaseRegister;
import com.coffee.sales.entities.BaseRole;
import com.coffee.sales.service.BaseCustomersService;
import com.coffee.sales.service.BaseRegisterService;


@RestController
@RequestMapping("v1/api/register")

public class ControllerRegister {
	
	@Autowired
	private BaseRegisterService registerService;
	private BaseCustomersService customersService;
	
	
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('"+BaseRole.ROLE_USER+"')")
	public ResponseEntity<List<BaseRegister>> getAllRegister(int id){
		
	  List<BaseRegister> register = registerService.getAllRegister(id);
	  return ResponseEntity.ok(register);
	
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('"+BaseRole.ROLE_USER+"')")
	public ResponseEntity<RegisterDTO>addRegister(@RequestBody RegisterDTO registerDTO , int codigo){
		
		// int codigo = customersService.getAllCustomersid(register);
		
		return ResponseEntity.ok(registerService.addRegister(registerDTO,codigo));
	}
	
}
