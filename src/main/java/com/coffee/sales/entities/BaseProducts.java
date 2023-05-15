package com.coffee.sales.entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name="products")
public class BaseProducts {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "description" )
	private String descrition;
	
	@Column(name = "user_id" )
	private int userId;
	
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "updated")
	private LocalDateTime updated;

	@Column(name = "deleted")
	private LocalDateTime deleted;
	
	
	

}
