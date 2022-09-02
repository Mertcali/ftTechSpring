package com.example.ftteknoloji.business.requests.products;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private int productId;
	private Date expirationDate;
	private String productName;
	private double price;
}
