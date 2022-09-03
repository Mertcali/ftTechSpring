package com.example.ftteknoloji.business.requests.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

	@NotNull
	@Positive
	private int userId;
	@NotNull
	@Size(min = 2)
	private String firstName;
	@NotNull
	@Size(min = 2)
	private String lastName;
	@NotNull
	@Email
	private String email;
	@Size(min = 15,max = 15)
	private String phoneNumber;
}
