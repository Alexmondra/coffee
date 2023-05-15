package com.coffee.sales.DTO;


import java.io.Serializable;
import java.util.Set;

import com.coffee.sales.entities.BaseRole;

import lombok.Data;

@Data
public class UserDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String dni;
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private Set<BaseRole> roles;
	

	





	
	
	
	
	

}
