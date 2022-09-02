package com.example.ftteknoloji.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ftteknoloji.business.abstracts.UserService;
import com.example.ftteknoloji.business.requests.users.CreateUserRequest;
import com.example.ftteknoloji.business.requests.users.DeleteUserRequest;
import com.example.ftteknoloji.business.requests.users.UpdateUserRequest;
import com.example.ftteknoloji.business.responses.users.GetUserResponse;
import com.example.ftteknoloji.business.responses.users.ListUsersResponse;
import com.example.ftteknoloji.core.utilities.mapping.ModelMapperService;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;
import com.example.ftteknoloji.core.utilities.results.SuccessDataResult;
import com.example.ftteknoloji.core.utilities.results.SuccessResult;
import com.example.ftteknoloji.dataAccess.abstracts.UserRepository;
import com.example.ftteknoloji.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	
	
	@Autowired
	public UserManager(UserRepository userRepository, ModelMapperService modelMapperService) {
		this.userRepository = userRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateUserRequest createUserRequest) {
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		this.userRepository.save(user);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateUserRequest updateUserRequest) {
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		this.userRepository.save(user);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteUserRequest deleteUserRequest) {
		User user = this.modelMapperService.forRequest().map(deleteUserRequest, User.class);
		this.userRepository.delete(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<GetUserResponse> getById(int id) {
		User user = this.userRepository.findById(id);
		GetUserResponse response = this.modelMapperService.forResponse().map(user, GetUserResponse.class);
		return new SuccessDataResult<GetUserResponse>(response);
	}

	@Override
	public DataResult<List<ListUsersResponse>> getAll() {
		List<User> result = this.userRepository.findAll();
		List<ListUsersResponse> response = result.stream()
				.map(user -> this.modelMapperService.forResponse()
				.map(user, ListUsersResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListUsersResponse>>(response);
	}

}
