package com.cos.blog.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
	int status;
	T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResponseDto(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	 
	 public ResponseDto() {
		// TODO Auto-generated constructor stub
	}
}
