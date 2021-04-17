package com.cos.blog.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		user.setPassword(encPassword);
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
	 System.out.println();
	 System.out.println();
	 System.out.println();
	}

	@Transactional 
	public void 회원수정(User user) {
		//영속성 컨텍스트에 user 오브젝트 영속화하고, 영속화된 user 오브젝트 수정할 것임.
		//영속화하려면 일단 첫번째로 기존 id에 따른 회원 정보를 가져오고, 가져온 값에 새로운 비밀번호만 수정하면 됨 
		User user_persistence = userRepository.findById(user.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("회원찾기 실패");
				});
		
		//유효성 체크 
		if(user_persistence.getOauth() == null || user_persistence.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user_persistence.setPassword(encPassword);
			user_persistence.setEmail(user.getEmail());
		} 
	
		
		
		
	}
	
	
	@Transactional(readOnly = true)
	public User 회원찾기(String username) {
		 
		User user = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
			
		});
		return user;
		
	}

	
	
//	@Transactional(readOnly = true) // select 할때 트랜젝션 시작. 서비스 종료시에 트랜잭션 종료(정합성) 
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//		
//	}
}
