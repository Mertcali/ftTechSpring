package com.example.ftteknoloji.business.concretes;

import java.util.ArrayList;
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
import com.example.ftteknoloji.core.exceptions.BusinessException;
import com.example.ftteknoloji.core.utilities.mapping.ModelMapperService;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;
import com.example.ftteknoloji.core.utilities.results.SuccessDataResult;
import com.example.ftteknoloji.core.utilities.results.SuccessResult;
import com.example.ftteknoloji.dataAccess.abstracts.UserRepository;
import com.example.ftteknoloji.entities.concretes.Product;
import com.example.ftteknoloji.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserManager(UserRepository userRepository, ModelMapperService modelMapperService) {
		this.userRepository = userRepository;
	}

	
//***************************CRUD OPERASYONLAR***************************	
	
	@Override
	public Result add(CreateUserRequest createUserRequest) {
		checkIfUserExists(createUserRequest.getEmail());
		User user = new User();
		user.setEmail(createUserRequest.getEmail());
		user.setFirstName(createUserRequest.getFirstName());
		user.setLastName(createUserRequest.getLastName());
		user.setPhoneNumber(createUserRequest.getPhoneNumber());
		user.setUserId(createUserRequest.getUserId());
		this.userRepository.save(user);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateUserRequest updateUserRequest) {
		User user = new User();
		user.setEmail(updateUserRequest.getEmail());
		user.setFirstName(updateUserRequest.getFirstName());
		user.setLastName(updateUserRequest.getLastName());
		user.setPhoneNumber(updateUserRequest.getPhoneNumber());
		user.setUserId(updateUserRequest.getUserId());
		this.userRepository.save(user);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteUserRequest deleteUserRequest) {
		User user = this.userRepository.findById(deleteUserRequest.getUserId());
		this.userRepository.delete(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<GetUserResponse> getById(int id) {
		User user = this.userRepository.findById(id);
		GetUserResponse response = new GetUserResponse();
		
		response.setEmail(user.getEmail());
		response.setFirstName(user.getEmail());
		response.setLastName(user.getLastName());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setUserId(user.getUserId());
		
		return new SuccessDataResult<GetUserResponse>(response);
	}

	@Override
	public DataResult<List<ListUsersResponse>> getAll() {
		List<User> result = this.userRepository.findAll();
		List<ListUsersResponse> response = new ArrayList<ListUsersResponse>();
		
		for (User user : result) {
			ListUsersResponse userResponse = new ListUsersResponse();
			userResponse.setEmail(user.getEmail());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setPhoneNumber(user.getPhoneNumber());
			userResponse.setUserId(user.getUserId());
			response.add(userResponse);
		}
		return new SuccessDataResult<List<ListUsersResponse>>(response);
	}
//***************************ÖRNEK İŞ KURALI***************************
	
	private void checkIfUserExists(String userEmail) {
		User tempUser = this.userRepository.findByEmail(userEmail);
		if(null!=tempUser) {
			throw new BusinessException("USER_EMAIL_EXISTS");
		}
	}
}
