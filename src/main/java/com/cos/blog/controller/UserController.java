package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	//인증이 안된 사용자들이 출입 할 수 있게끔 auth 경로 붙임. 
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm"; 
	}
	

	@GetMapping("/auth/loginForm") 
	public String loginForm() {
		return "user/loginForm"; 
	}
	
}
