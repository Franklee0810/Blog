package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//자동으로 빈 등록
public interface UserRepository extends JpaRepository<User, Integer> {

	//SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
	
}

//JPA naming 전략
//Select * from user WHERE username = ? and WHERE password = ?

//기존 로그인 전략 
//User findByUsernameAndPassword(String username, String password);

//@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//User login(String username, String password);