package com.coffee.sales.DTO;


import java.io.Serializable;

import lombok.Data;

@Data

public class RegisterDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String type;
	
	private float cant;
	
	private float price;
	
	private int productId;
	
	private int customerId;
	
	//private String customers;

}
