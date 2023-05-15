package com.coffee.sales.interfaces;

import com.coffee.sales.auth.app.JwtResponse;
import com.coffee.sales.auth.app.LoginRequest;
import com.coffee.sales.DTO.UserDTO;
import com.coffee.sales.auth.app.SignUpRequestDto;

public interface IUserServiceAuth {

	
	UserDTO signUp(SignUpRequestDto signUpRequestDto);
	
	JwtResponse login (LoginRequest loginRequest);
	
	
}
