package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

@Configuration //빈등록
@EnableWebSecurity //시큐리티 필터로 등록 설정
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증 미리 체크 
// 저 위에 세개는 세트
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //Ioc 설정 이제 스프링이 리턴값 관리 	
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	//시큐리티가 대신 로그인해주는데 password를 가로채기를 해서, 해당 패스워드가 뭘로 해쉬암호화 되어서 회원가입되었는지 알아야 로그인할때 DB에 있는 해쉬랑 비교할 수 있음
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD()); // userDetailService 의 파라미터에게 알려줘야함 어떻게 해쉬암호화 되었는지를..
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf 토큰 비활성화로 테스트시 걸어두는게 좋음 
			.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**") //이 주소 아니면 다 인증해야함.// 어느 누구도 들어올 수 있게끔 설정 .antMatchers("/auth.loginForm", "/auth/joinForm") , "/js/**" => js 경로 읽기 
				.permitAll()
				.anyRequest()  //이게 아닌 다른 모든 요청들은 
				.authenticated() // 인증되어야하게끔 설정 
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")  //인증이 되지않은 요청은 로그인폼으로 이동하게끔 설정(antMatchers(~~)가 아닌 모든 요청 ) //UserController 로그인폼 맵핑되어 있는 쪽으로 가서 loginForm.jsp 실행 // 즉, 인증이 필요한 곳으로 요청 들어오면, 	//여기로 들어오게끔 설정 즉, auth경로가 아니면 모두 다 인증이 필요하게끔 설정함.
				.loginProcessingUrl("/auth/loginProc") //인증되지 않은 요청을 로그인폼으로 이동했는데, 로그인을 수행하면, /auth/loginProc 액션 걸리게끔 설정함 //스프링시큐리티가 파라미터에 있는 주소로 요청오는 로그인을 가로챔. 
				.defaultSuccessUrl("/") // 위에 메소드가 실행되고 로그인하면 경로는 "/" 로 이동하게끔 설정 
				;
				//.failureUrl("/fail"); // 실패하면 여기 경로로 이동하게끔 설정
										
		
	}
	
}
