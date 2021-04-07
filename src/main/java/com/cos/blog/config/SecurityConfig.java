package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //빈등록
@EnableWebSecurity //시큐리티 필터로 등록 설정
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증 미리 체크 
// 저 위에 세개는 세트
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean //Ioc 설정 이제 스프링이 리턴값 관리 	
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/auth/**") // 어느 누구도 들어올 수 있게끔 설정 .antMatchers("/auth.loginForm", "/auth/joinForm")
				.permitAll()
				.anyRequest()  //이게 아닌 다른 모든 요청들은 
				.authenticated() // 인증되어야하게끔 설정 
			.and()
				.formLogin()
				.loginPage("/auth/loginForm"); //UserController 로그인폼 맵핑되어 있는 쪽으로 가서 loginForm.jsp 실행 // 즉, 인증이 필요한 곳으로 요청 들어오면, 
											//여기로 들어오게끔 설정 즉, auth경로가 아니면 모두 다 인증이 필요하게끔 설정함.
		
	}
	
}
