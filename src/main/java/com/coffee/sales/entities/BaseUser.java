package com.coffee.sales.entities;

import java.io.File;
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
@Table (name ="base_user")
public class BaseUser implements Serializable {
	

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
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "recover_pw")
	private String recoverPw;
		
	@Column (name = "img")
	private File img;
	
	
	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "updated")
	private LocalDateTime updated;

	@Column(name = "deleted")
	private LocalDateTime deleted;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "base_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<BaseRole> roles = new ArrayList<>();


	
	
}
	
	
	
