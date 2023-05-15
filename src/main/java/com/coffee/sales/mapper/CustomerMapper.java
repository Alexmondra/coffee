package com.coffee.sales.mapper;

import org.mapstruct.Mapper;

import com.coffee.sales.DTO.CustomersDTO;
import com.coffee.sales.entities.BaseCustomers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomersDTO toDTO(BaseCustomers baseCustomers);
	
    BaseCustomers toEntity(CustomersDTO customersDTO);
	
}
