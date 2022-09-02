package com.example.ftteknoloji.business.abstracts;

import java.util.List;

import com.example.ftteknoloji.business.requests.productReviews.CreateProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.DeleteProductReviewRequest;
import com.example.ftteknoloji.business.requests.productReviews.UpdateProductReviewRequest;
import com.example.ftteknoloji.business.responses.productReviews.GetProductReviewResponse;
import com.example.ftteknoloji.business.responses.productReviews.ListProductReviewsResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;

public interface ProductReviewService {
	
	Result add(CreateProductReviewRequest createProductReviewRequest);
	Result update(UpdateProductReviewRequest updateProductReviewRequest);
	Result delete(DeleteProductReviewRequest deleteProductReviewRequest);
	DataResult<GetProductReviewResponse> getById(int id);
	DataResult<List<ListProductReviewsResponse>> getAll();

}
