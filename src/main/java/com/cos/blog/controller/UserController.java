package com.cos.blog.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cos.blog.model.KakaoProfile;
import com.cos.blog.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("/user/updateForm") 
	public String updateForm() {
		return "user/updateForm"; 
	}
	
	@GetMapping("auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { //@ResponseBody는 데이터를 리턴해주는 컨트롤러 함수로 지정 
		
		RestTemplate rt = new RestTemplate(); // http 요청을 하기 위한 라이브러리 
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "b90e84953a8733902015e04084c684b5");
		params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
		params.add("code", code);
		
		//HttpHeader와 HttpBody를 하나의 오브젝트로 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		
		//Http 요청하기 - POST방식으로 - 그리고 response변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		
		//오브젝트에 맵퍼
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		try {
			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) { 
			e.printStackTrace();
		} catch (JsonProcessingException e) { 
			e.printStackTrace();
		}
		System.out.println(oauthToken.getAccess_token());
		
		
		
		//사용자 정보 요청 //
		RestTemplate rt2 = new RestTemplate(); // http 요청을 하기 위한 라이브러리 
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	 
		//HttpHeader와 HttpBody를 하나의 오브젝트로 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
		
		//Http 요청하기 - POST방식으로 - 그리고 response변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoProfileRequest,
				String.class
				);
		
		
		//오브젝트에 맵퍼
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) { 
			e.printStackTrace();
		} catch (JsonProcessingException e) { 
			e.printStackTrace();
		}
		
		System.out.println(kakaoProfile.getId());
		System.out.println(kakaoProfile.getKakao_Account().getEmail());
		return response2.getBody();
	}
	
	
}
