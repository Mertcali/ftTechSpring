package com.example.ftteknoloji.business.abstracts;

import java.util.List;

import com.example.ftteknoloji.business.requests.users.CreateUserRequest;
import com.example.ftteknoloji.business.requests.users.DeleteUserRequest;
import com.example.ftteknoloji.business.requests.users.UpdateUserRequest;
import com.example.ftteknoloji.business.responses.users.GetUserResponse;
import com.example.ftteknoloji.business.responses.users.ListUsersResponse;
import com.example.ftteknoloji.core.utilities.results.DataResult;
import com.example.ftteknoloji.core.utilities.results.Result;

public interface UserService {

	Result add(CreateUserRequest createUserRequest);
	Result update(UpdateUserRequest updateUserRequest);
	Result delete(DeleteUserRequest deleteUserRequest);
	DataResult<GetUserResponse> getById(int id);
	DataResult<List<ListUsersResponse>> getAll();
}
