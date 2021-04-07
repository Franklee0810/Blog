package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인 진행을 하고 완료가되면 UserDetails 타입의 오브젝트인 PrincipalDetail을 
// 스프링 시큐리티의 고유한 세션 저장소에 바인딩함 . 
public class PrincipalDetail implements UserDetails {
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}
    
	public User getUser() {
		return user;
	}
  
	@Override
	public String getPassword() { // 
		return user.getPassword();
	}

	@Override
	public String getUsername() { 
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() { //계정이 만료되지 않았는지 리턴 (true : 만료 안됨)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //계정이 잠겨있지 않았는지 리턴 (true: 안잠겨져있음)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호가 만료되지 않았는지 리턴 (true : 만료안됨)
		return true;
	}

	@Override
	public boolean isEnabled() { //계정이 활성화(사용가능)인지 리턴 (true : 활성화) 
		return true;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 계정이 갖고 있는 권한 목록을 리턴함 ( 권한이 여러개 있을수 있어서 loop로 돌아야하지만, 한개만 일단 .. 
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
	 
		collectors.add(()->{return "ROLE_" + user.getRole();}); //ROLE_ 은 반드시 붙여야함 스프링 약속 
		return collectors;
	}
}
