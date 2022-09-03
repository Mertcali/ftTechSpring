package com.example.ftteknoloji.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_reviews")
public class ProductReview {
	
	@Id()
	@Column(name = "product_review_id",unique = true,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productReviewId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "review")
	private String review;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "review_date")
	private LocalDate reviewDate;
	

	


}
