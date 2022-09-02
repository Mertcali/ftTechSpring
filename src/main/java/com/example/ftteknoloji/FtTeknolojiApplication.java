package com.example.ftteknoloji;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ftteknoloji.core.exceptions.BusinessException;
import com.example.ftteknoloji.core.utilities.results.ErrorDataResult;


@SpringBootApplication
public class FtTeknolojiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtTeknolojiApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessExceptions(BusinessException businessException) {
		ErrorDataResult<Object> error = new ErrorDataResult<Object>(businessException.getMessage(),
				"BusinessException");
		return error;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {

		Map<String, String> validationErrors = new HashMap<String, String>();

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation.Error");

		return errors;
	}

}
