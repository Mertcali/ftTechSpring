package com.example.ftteknoloji.business.abstracts;

import java.util.List;

import com.example.ftteknoloji.business.requests.products.CreateProductRequest;
import com.example.ftteknoloji.business.requests.products.DeleteProductRequest;
import com.example.ftteknoloji.business.requests.products.UpdateProductRequest;
import com.example.ftteknoloji.business.responses.products.GetProductResponse;
import com.example.ftteknoloji.business.responses.products.ListProductsResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;

public interface ProductService {
	
	Result add(CreateProductRequest createProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	DataResult<GetProductResponse> getById(int id);
	DataResult<List<ListProductsResponse>> getAll();
	
	DataResult<List<ListProductsResponse>> getProductsThatHaveNotExpired();
	DataResult<List<ListProductsResponse>> getProductsExpired();
	

}
