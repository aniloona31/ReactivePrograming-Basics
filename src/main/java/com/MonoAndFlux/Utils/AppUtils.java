package com.MonoAndFlux.Utils;

import org.springframework.beans.BeanUtils;

import com.MonoAndFlux.Dto.ProductDto;
import com.MonoAndFlux.Entity.Product;

public class AppUtils {

	public ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
//		productDto.setId(product.getId());
//		productDto.setPrice(product.getPrice());
//		productDto.setName(productDto.getName());
//		productDto.setQuantity(product.getQuantity());
		
		//shortcut to do the above thing, this can only be used if both the class have same attribute.
		BeanUtils.copyProperties(product, productDto);
		
		return productDto;
	}
	
	public Product dtoToEntity(ProductDto productDto) {
		Product product = new Product();
//		productDto.setId(product.getId());
//		productDto.setPrice(product.getPrice());
//		productDto.setName(productDto.getName());
//		productDto.setQuantity(product.getQuantity());
		
		//shortcut to do the above thing, this can only be used if both the class have same attribute.
		BeanUtils.copyProperties(productDto, product);
		
		return product;
	}
}
