package com.coffee.sales.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coffee.sales.DTO.ProductsDTO;
import com.coffee.sales.auth.jwt.JwtUser;
import com.coffee.sales.entities.BaseProducts;
import com.coffee.sales.mapper.ProductsMapper;
import com.coffee.sales.repository.BaseProductsRepository;

@Service
public class BaseProductsService extends AbstractService {
	
	private BaseProductsRepository productsRepository;
	private ProductsMapper productsMapper;
	
	public BaseProductsService(BaseProductsRepository productsRepository, ProductsMapper productsMapper) {
		
		super();
		this.productsMapper = productsMapper;
		this.productsRepository = productsRepository;
		
		
	}
	
	public List<BaseProducts> getAllProducts(){
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		List<BaseProducts> products =productsRepository.findByUserIdAndDeleted(user.getId(),null);
	     return products;
	}
	
	
	
	
	public ProductsDTO addProducts(ProductsDTO productsDTO) {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		BaseProducts newProduct = productsMapper.toEntity(productsDTO);
		
		newProduct.setCreated(LocalDateTime.now());
		
		newProduct.setUserId(user.getId());
		
		BaseProducts productReturn = saveProd(newProduct);
		ProductsDTO productDT = productsMapper.toDTO(productReturn);
		
		return productDT;
	}
	
	private BaseProducts saveProd(BaseProducts product) {
		return productsRepository.save(product);
	}

}
