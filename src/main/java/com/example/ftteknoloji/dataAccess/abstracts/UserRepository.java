package com.example.ftteknoloji.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ftteknoloji.entities.concretes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);

}
