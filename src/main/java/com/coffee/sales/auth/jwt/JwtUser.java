package com.coffee.sales.auth.jwt;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import com.bezkoder.springjwt.models.User;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.coffee.sales.entities.BaseUser;

public class JwtUser implements UserDetails {
	 private static final long serialVersionUID = 1L;

	  private int id;

	  private String username;
	  
	  private String lastName;
	  
	  //private String secondlastName;

	  private String email;

	  @JsonIgnore
	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;

	  public JwtUser(int id, String username, String lastName, String email, String password,
	      Collection<? extends GrantedAuthority> authorities) {
		  
	    this.id = id;
	    this.username = username;
	    this.lastName = lastName;
	    this.email = email;
	    this.password = password;
	    this.authorities = authorities;
	  }

	  public static JwtUser build(BaseUser user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getName()))
	        .collect(Collectors.toList());
	    
	  
	    return new JwtUser(
	        user.getId(), 
	        user.getName(), 
	        user.getLastName(),
	        user.getEmail(),
	        user.getPassword(), 	        
	        authorities);
	  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	  }

	  public int getId() {
	    return id;
	  }

	  public String getEmail() {
	    return email;
	  }
	  public String getLastName() {
		    return lastName;
	  }
	  

	  @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return username;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    JwtUser user = (JwtUser) o;
	    return Objects.equals(id, user.id);
	  }
  
}
