package com.example.ftteknoloji.business.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductsResponse {
	
	private int productId;
	private String productName;
	private double price;

}
