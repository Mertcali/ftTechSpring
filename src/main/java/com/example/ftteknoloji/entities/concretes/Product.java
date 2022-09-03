package com.example.ftteknoloji.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id()
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id",unique = true, nullable = false)
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "expiration_date")
	private LocalDate expirationDate;
	
	@OneToMany(mappedBy = "product")
	private List<ProductReview> productReviews;

}
