package com.example.ftteknoloji.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.example.ftteknoloji.core.exceptions.BusinessException;
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
	
//***************************İSTERLER***************************
	
	@Override
	public DataResult<List<ListProductsResponse>> getProductsThatHaveNotExpired() {
		List<Product> result = this.productRepository.findAll();
		List<ListProductsResponse> response = new ArrayList<ListProductsResponse>();
		
		for (Product product : result) {
			if(LocalDate.now().isBefore(product.getExpirationDate()) || LocalDate.now().equals(product.getExpirationDate())) {			
				ListProductsResponse responseProduct = new ListProductsResponse();
				responseProduct.setPrice(product.getPrice());
				responseProduct.setProductId(product.getProductId());
				responseProduct.setProductName(product.getProductName());
				responseProduct.setExpirationDate(product.getExpirationDate());
				response.add(responseProduct);
			}		

		}
		
		return new SuccessDataResult<List<ListProductsResponse>>(response);
	}

	@Override
	public DataResult<List<ListProductsResponse>> getProductsExpired() {
		List<Product> result = this.productRepository.findAll();
		List<ListProductsResponse> response = new ArrayList<ListProductsResponse>();
		
		for (Product product : result) {
			if(product.getExpirationDate()==null) {
				product.setExpirationDate(LocalDate.of(1111, 11, 11));
			}
			if(LocalDate.now().isAfter(product.getExpirationDate())) {			
				ListProductsResponse responseProduct = new ListProductsResponse();
				responseProduct.setPrice(product.getPrice());
				responseProduct.setProductId(product.getProductId());
				responseProduct.setProductName(product.getProductName());
				responseProduct.setExpirationDate(product.getExpirationDate());
				response.add(responseProduct);
			}		
		}
		
		return new SuccessDataResult<List<ListProductsResponse>>(response);
	}

//***************************CRUD OPERASYONLAR***************************
	
	@Override
	public Result add(CreateProductRequest createProductRequest) {
		checkIfProductExists(createProductRequest.getProductName());		
		Product product = new Product();
		product.setExpirationDate(createProductRequest.getExpirationDate());
		product.setPrice(createProductRequest.getPrice());
		product.setProductId(createProductRequest.getProductId());
		product.setProductName(createProductRequest.getProductName());
		this.productRepository.save(product);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = new Product();
		product.setExpirationDate(updateProductRequest.getExpirationDate());
		product.setPrice(updateProductRequest.getPrice());
		product.setProductId(updateProductRequest.getProductId());
		product.setProductName(updateProductRequest.getProductName());
		this.productRepository.save(product);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		Product product = this.productRepository.findById(deleteProductRequest.getProductId());
		this.productRepository.delete(product);
		return new SuccessResult();
	}
	
	@Override
	public DataResult<GetProductResponse> getById(int id) {
		Product product = this.productRepository.findById(id);
		GetProductResponse response = new GetProductResponse();
		
		response.setPrice(product.getPrice());
		response.setProductId(product.getProductId());
		response.setProductName(product.getProductName());
		response.setExpirationDate(product.getExpirationDate());
		
		return new SuccessDataResult<>(response);
	}

	@Override
	public DataResult<List<ListProductsResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ListProductsResponse> response = new ArrayList<ListProductsResponse>();
		
		for (Product product : result) {
			ListProductsResponse responseProduct = new ListProductsResponse();
			responseProduct.setPrice(product.getPrice());
			responseProduct.setProductId(product.getProductId());
			responseProduct.setProductName(product.getProductName());
			responseProduct.setExpirationDate(product.getExpirationDate());
			response.add(responseProduct);
		}
		
		return new SuccessDataResult<List<ListProductsResponse>>(response);
	}
	
	
	
	
//***************************ÖRNEK İŞ KURALI***************************
	
	private void checkIfProductExists(String productName) {
		Product tempProduct = this.productRepository.findByProductName(productName);
		if(null!=tempProduct) {
			throw new BusinessException("PRODUCT_NAME_EXISTS");
		}
	}



}
