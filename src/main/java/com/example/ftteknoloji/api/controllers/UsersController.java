package com.example.ftteknoloji.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ftteknoloji.business.abstracts.UserService;
import com.example.ftteknoloji.business.requests.users.CreateUserRequest;
import com.example.ftteknoloji.business.requests.users.DeleteUserRequest;
import com.example.ftteknoloji.business.requests.users.UpdateUserRequest;
import com.example.ftteknoloji.business.responses.users.GetUserResponse;
import com.example.ftteknoloji.business.responses.users.ListUsersResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public void add(CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateUserRequest updateUserRequest) {
		this.userService.update(updateUserRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteUserRequest deleteUserRequest) {
		this.userService.delete(deleteUserRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<GetUserResponse> getById(int id){
		return this.userService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListUsersResponse>> getAll(){
		return this.userService.getAll();
	}
}
