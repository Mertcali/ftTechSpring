package com.example.ftteknoloji.business.requests.productReviews;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductReviewRequest {
	
	@NotNull
	@Positive
	private int productId;
	@NotNull
	@Positive
	private int userId;
	@NotNull
	@Size(min = 1)
	private String review;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reviewDate;


}
