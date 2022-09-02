package com.example.ftteknoloji.business.requests.productReviews;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductReviewRequest {
	
	private int productId;
	private int userId;
	private String review;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reviewDate;


}
