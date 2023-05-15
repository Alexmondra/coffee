package com.coffee.sales.entities;

import java.io.File;
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
@Table (name ="customers")

public class BaseCustomers {

	private static final long serialVersionUID = 1L;
	
	public static final int REGISTER_STATUS_CREATED = 0;
    public static final int REGISTER_STATUS_VALIDATED = 1;
    public static final int REGISTER_STATUS_COMPLETED = 2;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dni" )
	private String dni;
	
	@Column(name = "name" )
	private String name;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "phone")
	private String phone;
	
	@Column (name = "register_status")
	private int registerStatus;
	
	@Column (name = "base_user_id")
	private int baseUserId ;
		
	@Column (name = "img")
	private File img;
	
	
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "updated")
	private LocalDateTime updated;

	@Column(name = "deleted")
	private LocalDateTime deleted;
		
}
