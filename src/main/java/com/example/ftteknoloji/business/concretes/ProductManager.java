package com.example.ftteknoloji.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ftteknoloji.business.abstracts.ProductService;
import com.example.ftteknoloji.business.requests.products.CreateProductRequest;
import com.example.ftteknoloji.business.requests.products.DeleteProductRequest;
import com.example.ftteknoloji.business.requests.products.UpdateProductRequest;
import com.example.ftteknoloji.business.responses.products.GetProductResponse;
import com.example.ftteknoloji.business.responses.products.ListProductsResponse;
import com.example.ftteknoloji.core.utilities.mapping.ModelMapperService;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;
import com.example.ftteknoloji.core.utilities.results.SuccessDataResult;
import com.example.ftteknoloji.core.utilities.results.SuccessResult;
import com.example.ftteknoloji.dataAccess.abstracts.ProductRepository;
import com.example.ftteknoloji.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{
	
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	

	@Autowired
	public ProductManager(ProductRepository productRepository,
			ModelMapperService modelMapperService) {
		this.productRepository = productRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		Product product = this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
		this.productRepository.delete(product);
		return new SuccessResult();
	}

	@Override
	public DataResult<GetProductResponse> getById(int id) {
		Product product = this.productRepository.findById(id);
		GetProductResponse response = this.modelMapperService.forResponse().map(product, GetProductResponse.class);
		
		return new SuccessDataResult<>(response);
	}

	@Override
	public DataResult<List<ListProductsResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ListProductsResponse> response = result.stream()
				.map(product -> this.modelMapperService.forResponse()
						.map(product, ListProductsResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListProductsResponse>>(response);
	}

}
