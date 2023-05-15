package com.coffee.sales.mapper;

import org.mapstruct.Mapper;

import com.coffee.sales.DTO.RegisterDTO;
import com.coffee.sales.entities.BaseRegister;

@Mapper(componentModel = "spring")

public interface RegisterMapper {
    
	RegisterDTO toDTO (BaseRegister baseRegister);
    
	BaseRegister toEntity(RegisterDTO registerDTO);
	
}
