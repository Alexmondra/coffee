package com.coffee.sales.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;

@Data

@Entity
@Table (name ="registeraction")

public class BaseRegister implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int REGISTER_STATUS_CREATED = 0;
    public static final int REGISTER_STATUS_VALIDATED = 1;
    public static final int REGISTER_STATUS_COMPLETED = 2;

    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type" )
	private String type;
	
	@Column(name = "cant" )
	private float cant;
	
	@Column(name = "price" )
	private float price;
	
	@Column(name = "discount" )
	private int discount;
	
	@Column(name = "product_id" )
	private int productId;
	
	@Column(name = "customer_id" )
	private int customerId;
	
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "updated")
	private LocalDateTime updated;

	@Column(name = "deleted")
	private LocalDateTime deleted;
	
	
}
