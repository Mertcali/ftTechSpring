package com.example.ftteknoloji.business.responses.products;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
	
	private int productId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expirationDate;
	private String productName;
	private double price;

}
