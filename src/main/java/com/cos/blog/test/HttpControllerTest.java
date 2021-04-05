package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : " ;
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1, "min", "1234", "이메일");
		System.out.println(TAG + "getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : " + m.getId() );
		
		return "테스트 ";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		
		return "get 요청 : " +m.getId() +", " +  m.getUsername() + " , "+ m.getPassword();
	} 
	@PostMapping("/http/post")
	public String postTest() {
		return "post 요청";
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
	
}
