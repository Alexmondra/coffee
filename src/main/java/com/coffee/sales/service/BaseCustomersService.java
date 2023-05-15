package com.coffee.sales.service;

import java.security.Principal;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.sales.DTO.CustomersDTO;
import com.coffee.sales.auth.jwt.JwtUser;
import com.coffee.sales.entities.BaseCustomers;
import com.coffee.sales.mapper.CustomerMapper;
import com.coffee.sales.repository.BaseCustomersRepository;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Service
public class BaseCustomersService extends AbstractService {
	
	
	private BaseCustomersRepository customersRepository;
	private CustomerMapper customerMapper;
	
	public BaseCustomersService(BaseCustomersRepository customersRepository, CustomerMapper customerMapper) {
		
		super();
		this.customerMapper = customerMapper;
		this.customersRepository = customersRepository;
	}
	
	public List<BaseCustomers> getAllCustomers() {

		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<BaseCustomers> clientela = customersRepository.findByBaseUserIdAndDeleted(user.getId(),null);
		
		return clientela;
	}
		
	public CustomersDTO addcustomer(CustomersDTO customersDTO){
		
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		BaseCustomers newCustomers = customerMapper.toEntity(customersDTO);
		newCustomers.setCreated(LocalDateTime.now());
		newCustomers.setBaseUserId(user.getId());
		newCustomers.setRegisterStatus(BaseCustomers.REGISTER_STATUS_COMPLETED);
		BaseCustomers custoRetur = saveCust(newCustomers);
		CustomersDTO customersDT = customerMapper.toDTO(custoRetur);
		return  customersDT;
		
	}
	
	
	private BaseCustomers saveCust(BaseCustomers cust) {
		return customersRepository.save(cust);
	}
	
	
	
}


