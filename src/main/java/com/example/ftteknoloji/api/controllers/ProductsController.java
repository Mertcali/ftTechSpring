package com.example.ftteknoloji.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ftteknoloji.business.abstracts.ProductService;
import com.example.ftteknoloji.business.requests.products.CreateProductRequest;
import com.example.ftteknoloji.business.requests.products.DeleteProductRequest;
import com.example.ftteknoloji.business.requests.products.UpdateProductRequest;
import com.example.ftteknoloji.business.responses.products.GetProductResponse;
import com.example.ftteknoloji.business.responses.products.ListProductsResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	}
	
	@PostMapping("/add")
	public void add(CreateProductRequest createProductRequest) {
		this.productService.add(createProductRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateProductRequest updateProductRequest) {
		this.productService.update(updateProductRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteProductRequest deleteProductRequest) {
		this.productService.delete(deleteProductRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<GetProductResponse> getById(int id){
		return this.productService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListProductsResponse>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getproductsthathavenotexpired")
	public DataResult<List<ListProductsResponse>> getProductsThatHaveNotExpired(){
		return this.productService.getProductsThatHaveNotExpired();
	}
	
	@GetMapping("/getproductsexpired")
	public DataResult<List<ListProductsResponse>> getProductsExpired(){
		return this.productService.getProductsExpired();
	}

}
