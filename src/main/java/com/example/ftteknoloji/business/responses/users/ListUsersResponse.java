package com.example.ftteknoloji.business.responses.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUsersResponse {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
}
