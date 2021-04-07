package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service //빈 등록
public class PrincipalDetailService implements UserDetailsService{

 
	@Autowired
	private UserRepository userRepository;
	
	//스프링 로그인 요청 가로챌때, username, password 변수 2개를 가로채면서, 
	// password는 알아서 처리하지만, username이 db에 있는지 확인해주는 작업이 필요하기 떄문에 여기서 설정해야함. 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username) //데이터 타입이 Optional이므로 예외로 람다식으로 던진다 
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당사용자 찾을 수 없습니다" + username);
				});
		return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보 저장 
	}
}
