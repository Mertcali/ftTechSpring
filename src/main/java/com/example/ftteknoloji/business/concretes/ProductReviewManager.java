package com.example.ftteknoloji.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ftteknoloji.business.abstracts.ProductReviewService;
import com.example.ftteknoloji.business.requests.productReviews.CreateProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.DeleteProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.UpdateProductReviewRequest;
import com.example.ftteknoloji.business.responses.productReviews.GetProductReviewResponse;
import com.example.ftteknoloji.business.responses.productReviews.ListProductReviewsResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;
import com.example.ftteknoloji.core.utilities.results.SuccessDataResult;
import com.example.ftteknoloji.core.utilities.results.SuccessResult;
import com.example.ftteknoloji.dataAccess.abstracts.ProductRepository;
import com.example.ftteknoloji.dataAccess.abstracts.ProductReviewRepository;
import com.example.ftteknoloji.dataAccess.abstracts.UserRepository;
import com.example.ftteknoloji.entities.concretes.ProductReview;

@Service
public class ProductReviewManager implements ProductReviewService{
	
	private ProductReviewRepository productReviewRepository;
	private UserRepository userRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public ProductReviewManager(ProductReviewRepository productReviewRepository,
			UserRepository userRepository,
			ProductRepository productRepository) {
		this.productReviewRepository = productReviewRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	//Burada modelMapper yerine manuelMapping kullandım. Lombok builder tercih edilebilir.
	@Override
	public Result add(CreateProductReviewRequest createProductReviewRequest) {
		ProductReview productReview = new ProductReview();
		productReview.setProduct(this.productRepository.findById(createProductReviewRequest.getProductId()));
		productReview.setReview(createProductReviewRequest.getReview());
		productReview.setReviewDate(createProductReviewRequest.getReviewDate());
		productReview.setUser(this.userRepository.findById(createProductReviewRequest.getUserId()));
		this.productReviewRepository.save(productReview);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateProductReviewRequest updateProductReviewRequest) {
		ProductReview productReview = new ProductReview();
		productReview.setProduct(this.productRepository.findById(updateProductReviewRequest.getProductId()));
		productReview.setReview(updateProductReviewRequest.getReview());
		productReview.setReviewDate(updateProductReviewRequest.getReviewDate());
		productReview.setUser(this.userRepository.findById(updateProductReviewRequest.getUserId()));
		this.productReviewRepository.save(productReview);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteProductReviewRequest deleteProductReviewRequest) {
		ProductReview productReview = new ProductReview();
		productReview.setProductReviewId(deleteProductReviewRequest.getProductReviewId());
		this.productReviewRepository.delete(productReview);
		return new SuccessResult();
	}

	@Override
	public DataResult<GetProductReviewResponse> getById(int id) {
		ProductReview productReview = this.productReviewRepository.findById(id);
		GetProductReviewResponse response = new GetProductReviewResponse();
		response.setProductId(productReview.getProduct().getProductId());
		response.setProductReviewId(id);
		response.setReview(productReview.getReview());
		response.setReviewDate(productReview.getReviewDate());
		response.setUserId(productReview.getUser().getUserId());
		
		return new SuccessDataResult<GetProductReviewResponse>(response);
	}

	@Override
	public DataResult<List<ListProductReviewsResponse>> getAll() {
		List<ProductReview> result = this.productReviewRepository.findAll();
		List<ListProductReviewsResponse> response = new ArrayList<ListProductReviewsResponse>();
		
		for (ProductReview productReview : result) {
			ListProductReviewsResponse responseProductReview = new ListProductReviewsResponse();
			responseProductReview.setProductId(productReview.getProduct().getProductId());
			responseProductReview.setProductReviewId(productReview.getProductReviewId());
			responseProductReview.setReview(productReview.getReview());
			responseProductReview.setReviewDate(productReview.getReviewDate());
			responseProductReview.setUserId(productReview.getUser().getUserId());
			response.add(responseProductReview);
			
		}
				
		return new SuccessDataResult<List<ListProductReviewsResponse>>(response);
	}

}
