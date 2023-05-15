package com.coffee.sales.mapper;

import org.mapstruct.Mapper;

import com.coffee.sales.DTO.ProductsDTO;
import com.coffee.sales.entities.BaseProducts;

@Mapper(componentModel = "spring")

public interface ProductsMapper {

	ProductsDTO toDTO (BaseProducts baseProducts);
	BaseProducts toEntity(ProductsDTO productsDTO);
	
}
