package com.example.ftteknoloji.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ftteknoloji.entities.concretes.ProductReview;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer>{

	ProductReview findById(int id);
}
