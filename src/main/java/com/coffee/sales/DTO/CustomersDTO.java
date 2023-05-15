package com.coffee.sales.DTO;

import java.io.Serializable;
import lombok.Data;

@Data

public class CustomersDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String dni;
	
	private String name;
	
	private String lastName;
	
	private String email;

	private int baseUserId;
	
	private int registerStatus;
	
	
}
