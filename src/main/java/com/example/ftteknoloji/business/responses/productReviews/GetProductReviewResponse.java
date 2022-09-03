package com.example.ftteknoloji.business.responses.productReviews;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductReviewResponse {
	
	private int productReviewId;
	private String review;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reviewDate;
	private int productId;
	private int userId;

}
