package com.example.ftteknoloji.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

	private int productId;
	private String productName;
	private double price;
}
