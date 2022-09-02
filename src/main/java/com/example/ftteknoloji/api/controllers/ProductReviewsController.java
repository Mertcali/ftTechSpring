package com.example.ftteknoloji.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ftteknoloji.business.abstracts.ProductReviewService;
import com.example.ftteknoloji.business.requests.productReviews.CreateProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.DeleteProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.UpdateProductReviewRequest;
import com.example.ftteknoloji.business.responses.productReviews.GetProductReviewResponse;
import com.example.ftteknoloji.business.responses.productReviews.ListProductReviewsResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/productreviews")
public class ProductReviewsController {
	
	private ProductReviewService productReviewService;

	@Autowired
	public ProductReviewsController(ProductReviewService productReviewService) {
		this.productReviewService = productReviewService;
	}
	
	@PostMapping("/add")
	public void add(CreateProductReviewRequest createProductReviewRequest) {
		this.productReviewService.add(createProductReviewRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateProductReviewRequest updateProductReviewRequest) {
		this.productReviewService.update(updateProductReviewRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteProductReviewRequest deleteProductReviewRequest) {
		this.productReviewService.delete(deleteProductReviewRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<GetProductReviewResponse> getById(int id){
		return this.productReviewService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListProductReviewsResponse>> getAll(){
		return this.productReviewService.getAll();
	}
}
