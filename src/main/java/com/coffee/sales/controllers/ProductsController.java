package com.coffee.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.sales.DTO.ProductsDTO;
import com.coffee.sales.entities.BaseProducts;
import com.coffee.sales.entities.BaseRole;
import com.coffee.sales.service.BaseProductsService;

@RestController
@RequestMapping("v1/api/products")
public class ProductsController {
	
	@Autowired
	private BaseProductsService productsService;
	
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('"+BaseRole.ROLE_USER+"')")
	public ResponseEntity<List<BaseProducts>> getAllProducts(){
		
		List<BaseProducts> product = productsService.getAllProducts();
		return ResponseEntity.ok(product);
	}
	
	
	@PostMapping("/add")
    public ResponseEntity<ProductsDTO> addProducts(@RequestBody ProductsDTO productsDTO){
		return ResponseEntity.ok(productsService.addProducts(productsDTO));	
	 }

}
