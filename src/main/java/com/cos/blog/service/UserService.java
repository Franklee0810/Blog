package com.cos.blog.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔 통해서 빈에 등록 IOC
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional // 성공하면 커밋 될 것임 실패하면 롤백 
	public void 회원가입(User user) {
		
		String rawPassword = user.getPassword(); //Original Password
		
		String encPassword = encoder.encode(rawPassword); //Hashed Password
		user.setRole(RoleType.USER);
		userRepository.save(user);
	 System.out.println();
	}

	
	
//	@Transactional(readOnly = true) // select 할때 트랜젝션 시작. 서비스 종료시에 트랜잭션 종료(정합성) 
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//		
//	}
}
