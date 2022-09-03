package com.example.ftteknoloji.business.requests.products;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

	@NotNull
	@Positive
	private int productId;
	@Nullable
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expirationDate;
	@NotNull
	@Size(min = 1)
	private String productName;
	@Positive
	private double price;
}
