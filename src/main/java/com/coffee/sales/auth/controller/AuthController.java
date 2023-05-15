package com.coffee.sales.auth.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.sales.DTO.UserDTO;
import com.coffee.sales.auth.app.JwtResponse;
import com.coffee.sales.auth.app.LoginRequest;
import com.coffee.sales.auth.app.SignUpRequestDto;
import com.coffee.sales.service.UserServiceAuth;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private UserServiceAuth userServiceAuth;

	public AuthController(UserServiceAuth userServiceAuth) {
		super();
		this.userServiceAuth = userServiceAuth;
	}

	/**
	 * Logea un usuario
	 * 
	 * @param loginRequest
	 * @return
	 */

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		JwtResponse jwtResponse = userServiceAuth.login(loginRequest);
		String jwt = jwtResponse.getJwt();

		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Access-Control-Expose-Headers", "Authorization");

		headers.add("Authorization", "Bearer " + jwt);

		return ResponseEntity.ok(jwtResponse);

	}

	/**
	 * Registra un usuario
	 * 
	 * @param signUpRequest
	 * @return
	 */
	@PostMapping("/signUp")
	public ResponseEntity<UserDTO> registerUser(@RequestBody SignUpRequestDto signUpRequest) {

		UserDTO baseClientes = userServiceAuth.signUp(signUpRequest);

		return ResponseEntity.ok(baseClientes);
	}

	
	


}