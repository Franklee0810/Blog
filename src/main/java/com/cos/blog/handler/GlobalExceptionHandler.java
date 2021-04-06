package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 예외가 발생하면 여기로 오는 어노테이션 
@RestController
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value=IllegalArgumentException.class) //IllegalArgumentException이 발생하면, 예외를 이 메소드 파라미터 e에 전달한다. 
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
