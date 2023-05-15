package com.coffee.sales.mapper;


import com.coffee.sales.DTO.BaseUserDTO;
import com.coffee.sales.DTO.SignUpDto;
import com.coffee.sales.DTO.UserDTO;
import com.coffee.sales.entities.BaseUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


	UserDTO userDTO(BaseUser baseUser);

	BaseUser userToEntity(UserDTO userDTO);
	
	BaseUserDTO toDTO(BaseUser baseUser);

	BaseUser toEntity(BaseUserDTO baseUserDTO);






	//@Mapping(target = "password", ignore = true)
	//User signUpToUser(SignUpDto signUpDto);

	@Mapping(target = "password", ignore = true)
	BaseUser signUpToBaseUser(SignUpDto signUpDto);

}
