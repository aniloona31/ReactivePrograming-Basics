package com.MonoAndFlux.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	private String name;
	private Integer id;
	private int quantity;
	private double price;
}
