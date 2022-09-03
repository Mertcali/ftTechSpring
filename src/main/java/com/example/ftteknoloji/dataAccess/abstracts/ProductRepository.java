package com.example.ftteknoloji.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ftteknoloji.entities.concretes.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findById(int id);
	Product findByProductName(String name);

}
