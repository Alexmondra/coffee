package com.coffee.sales.auth.app;

import java.util.List;
import lombok.Data;

@Data

public class JwtResponse {
	

	private int id;
	
	private String name;
	
	private String lastName;
	
	private String email;
	

	private List<String> roles;

	private String jwt;


	
	

	

}
