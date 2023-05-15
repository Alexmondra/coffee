package com.coffee.sales.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.coffee.sales.auth.app.JwtResponse;
import com.coffee.sales.auth.app.LoginRequest;
import com.coffee.sales.auth.app.SignUpRequestDto;
import com.coffee.sales.auth.jwt.JwtUser;
import com.coffee.sales.auth.jwt.JwtUtils;
import com.coffee.sales.DTO.UserDTO;
import com.coffee.sales.entities.BaseRole;
import com.coffee.sales.entities.BaseUser;
import com.coffee.sales.interfaces.IUserServiceAuth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coffee.sales.mapper.UserMapper;
import com.coffee.sales.repository.BaseRoleRepository;
import com.coffee.sales.repository.BaseUserRepository;



/**
 * 
 * @author miguelmondragon
 *
 */
@Service
public class UserServiceAuth extends AbstractService implements IUserServiceAuth {

	
	private final AuthenticationManager authenticationManager;
	
	private final BaseUserRepository baseUserRepository;
	
	private final BaseRoleRepository roleRepository;
	
	private final PasswordEncoder encoder;
	
	private final JwtUtils jwtUtils;
	
	private final ValidatorService validatorService;
	
	private final BaseUserService baseUserService;
	
	private final UserMapper userMapper;
	
	
	private static final String ADMIN ="admin";
	private static final String USER ="user";
	private static final String CLIENT ="client";
	
	

	

	public UserServiceAuth(AuthenticationManager authenticationManager, BaseUserRepository baseUserRepository,
						   BaseRoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils,
						   ValidatorService validatorService, BaseUserService baseUserService, UserMapper userMapper
						  ) {
		super();
		this.authenticationManager = authenticationManager;
		this.baseUserRepository = baseUserRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
		this.validatorService = validatorService;
		this.baseUserService = baseUserService;
		this.userMapper=userMapper;
		
	}

	/**
	 * Loguea un usuario 
	 * @param loginRequest
	 * @return
	 */
	public JwtResponse login (LoginRequest loginRequest) {
		
		//Comprueba que exista el email 
		baseUserService.findUserByEmail(loginRequest.getEmail());
		
		Authentication authentication = null;
		
		try {			
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));			
		} catch (Exception e) {
			
			notifyError(IBaseUserServiceErrorCode.WRONG_PASWORD);
		}
				

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
		List<String> roles = jwtUser.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		//return 
		JwtResponse response = new JwtResponse();
		response.setId(jwtUser.getId());
		response.setLastName(jwtUser.getLastName());
		response.setName(jwtUser.getUsername());		
		response.setEmail(jwtUser.getEmail());
		response.setRoles(roles);
	
		response.setJwt(jwt);
		
		return response;
	}
	

	
	/**
	 * Hace el registro de un usuario con roles 
	 * @param signUpRequestDto
	 * @return
	 */
	public UserDTO signUp(SignUpRequestDto signUpRequestDto) {

		Optional<BaseUser> optBaseUser = baseUserRepository.findByEmailAndDeleted(signUpRequestDto.getEmail(), null);
		if(optBaseUser.isPresent()) {
			notifyError(IBaseUserServiceErrorCode.EXIST_EMAIL);
		}
		
		validatorService.validateNotNull(signUpRequestDto.getEmail(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		validatorService.validateNotNull(signUpRequestDto.getName(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		//validatorService.validateNotNull(signUpRequestDto.getLastName(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		//validatorService.validateNotNull(signUpRequestDto.getDni(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		  //validatorService.validateNotNull(signUpRequestDto.getSecondLastName(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		  //validatorService.validateNotNull(signUpRequestDto.getPostCode(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		  //validatorService.validateNotNull(signUpRequestDto.getTownCode(), IValidatorServiceErrorCode.FIELD_REQUIRED);
		validatorService.validateEmail(signUpRequestDto.getEmail() , IValidatorServiceErrorCode.BAD_EMAIL_FORMAT);

		//Town town = provinceTownService.findTownById(signUpRequestDto.getTownCode());

		log.info("Se va a crear un nuevo usuario " + signUpRequestDto.getEmail().split("@")[0]);
		BaseUser baseUser = new BaseUser();
		baseUser.setName(signUpRequestDto.getName());
		baseUser.setLastName(signUpRequestDto.getLastName());
		baseUser.setDni(signUpRequestDto.getDni());
		//baseUser.setSecondLastName(signUpRequestDto.getSecondLastName());
		baseUser.setEmail(signUpRequestDto.getEmail());
		baseUser.setPassword(encoder.encode(signUpRequestDto.getPassword()));
		baseUser.setCreated(LocalDateTime.now());
		//baseUser.setPostCode(signUpRequestDto.getPostCode());
		//baseUser.setTown(town.getName());
		//baseUser.setDefaultLang("ES");		
		baseUser.setRegisterStatus(BaseUser.REGISTER_STATUS_COMPLETED);

		
		//Set<BaseRole> roles =  new HashSet<BaseRole>();
		//roles.add(roleRepository.findByName(BaseRole.ROLE_USER));
		List<BaseRole> roles = new ArrayList<>();
		roles.add(roleRepository.findByName(BaseRole.ROLE_USER));
		baseUser.setRoles(roles);	
		
		baseUser = saveBaseUser(baseUser);
		
		log.info("Usuario " + baseUser.getEmail().split("@")[0] + " creado correctamente");
		
		return userMapper.userDTO(baseUser);
		
	}
	
	
	
	
	private Set<BaseRole> getRoles (String rolesString ){
		String[] strParts = rolesString.split(",");
		Set<BaseRole> roles =  new HashSet<BaseRole>();
        List<String> listParts = Arrays.asList(strParts);
        
        for (String role : listParts) {
        	      	
        	switch (role) {
			case ADMIN:
				BaseRole adminRole = roleRepository.findByName(BaseRole.ROLE_ADMIN);

				roles.add(adminRole);

				break;
			case CLIENT:
				BaseRole modRole = roleRepository.findByName(BaseRole.ROLE_CLIENT);

				roles.add(modRole);

				break;
			default:
				BaseRole userRole = roleRepository.findByName(BaseRole.ROLE_USER);

				roles.add(userRole);
				}
				
			
        }
                 
        return roles;
		
	}

	/**
	 * Guarda un usuario 
	 * @param baseUser
	 * @return
	 */
	private BaseUser saveBaseUser(BaseUser baseUser) {
		
		return baseUserRepository.save(baseUser);
	}

}



