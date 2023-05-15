package com.coffee.sales.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.sales.DTO.RegisterDTO;
import com.coffee.sales.auth.jwt.JwtUser;
import com.coffee.sales.entities.BaseRegister;
import com.coffee.sales.mapper.RegisterMapper;
import com.coffee.sales.repository.BaseRegisterRepository;

@Service
public class BaseRegisterService extends AbstractService {

	private BaseRegisterRepository registerRepository;
	private RegisterMapper registerMapper;
	
	public BaseRegisterService(BaseRegisterRepository registerRepository, RegisterMapper registerMapper) {
		
		super();
		this.registerMapper = registerMapper;
		this.registerRepository = registerRepository;
	}
	
	
	public List<BaseRegister>getAllRegister(int codigo){
		
		List<BaseRegister> regist = registerRepository.findByCustomerIdAndDeleted(codigo, null);
		
		return regist;
	}
	
	
	
	public RegisterDTO addRegister(RegisterDTO registerDTO, int codigo){
		
		BaseRegister newRegister = registerMapper.toEntity(registerDTO);
		
		newRegister.setCreated(LocalDateTime.now());
		newRegister.setProductId(1);
		//newRegister.setRegisterStatus(BaseCustomers.REGISTER_STATUS_COMPLETED);

		newRegister.setCustomerId(codigo);
		BaseRegister registRetur = saveRegi(newRegister);
		RegisterDTO registerDT = registerMapper.toDTO(registRetur);
		return  registerDT;
		
	}
	
	
	
	
	private BaseRegister saveRegi(BaseRegister regist) {
		return registerRepository.save(regist);
	}
	
	
	
	
	
	
}
