package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//자동으로 빈 등록
public interface UserRepository extends JpaRepository<User, Integer> {
	//JPA naming 전략
	//Select * from user WHERE username = ? and WHERE password = ?
	User findByUsernameAndPassword(String username, String password);
	
	//@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	//User login(String username, String password);
}
