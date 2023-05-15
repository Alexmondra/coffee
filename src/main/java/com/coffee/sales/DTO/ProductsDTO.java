package com.coffee.sales.DTO;

import java.io.Serializable;

import lombok.Data;

@Data

public class ProductsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	private int id;
	
	private String name;
	
	private String description;
	
	private int userId;
	

}
