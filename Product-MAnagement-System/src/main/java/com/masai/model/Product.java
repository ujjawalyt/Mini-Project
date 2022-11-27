package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productid;
	
	@NotNull(message = "Product Name should not be null")
	private String productName;
	
	@NotNull(message ="Quantity should not ne null")
	private Integer quality;
	
	
	@NotNull(message ="Price should not ne null")
	private double price;
	
	
	@NotNull(message ="category should not ne null")
	private String category;

	@NotNull(message ="color should not ne null")
	private String color;
	@NotNull(message ="dimension should not ne null")
	private String dimension;
	@NotNull(message ="specification should not ne null")
	private String specification;
	@NotNull(message ="manufacturershould not ne null")
	private String manufacturer;
	
	
}
