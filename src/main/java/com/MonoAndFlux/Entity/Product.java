package com.MonoAndFlux.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity wont work as i am working with mongo db and it has document annotation
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "products")
public class Product {
	private String name;
	
	@Id
	private Integer id;
	
	private int quantity;
	
	private double price;
}
