package com.spring.springboot.response;

import org.springframework.http.HttpStatus;


public class ResponseStructure <T>{

	
	private String message;
	private HttpStatus httpStatus;
	private int httpcode;
	private T data;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public int getHttpcode() {
		return httpcode;
	}
	public void setHttpcode(int httpcode) {
		this.httpcode = httpcode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
