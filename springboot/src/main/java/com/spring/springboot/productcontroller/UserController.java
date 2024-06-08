package com.spring.springboot.productcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.pojo.User;
import com.spring.springboot.productservice.UserServices;
import com.spring.springboot.response.ResponseStructure;

@RestController
public class UserController {

	
	@Autowired
	private UserServices services;
	
	@PostMapping("/add_user")
	public ResponseStructure<User>addUser(@RequestBody User user) {
			
	  User addUser = services.addUser(user);
	  ResponseStructure<User> responseStructure=new ResponseStructure<>();
	  if (addUser!=null) {
		responseStructure.setData(addUser);
		responseStructure.setHttpcode(HttpStatus.CREATED.value());
		responseStructure.setHttpStatus(HttpStatus.CREATED);
		responseStructure.setMessage("User Added");
	}
	  else {
		
			responseStructure.setHttpcode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseStructure.setMessage("User Not Added");
	}
	  return responseStructure;
	}
	
	@GetMapping("/findUserById")
	public Object findUserById(long userId) {
		return services.findUserById(userId);
	}
	
	@GetMapping("/finduserbyemailandpassword")
	public Object  findUserByEmailAndPassword(@RequestParam(name="email") String email, @RequestParam(name="password") String password) {
		Object findUserByEmailAndPassword = services.findUserByEmailAndPassword(email,password);
		ResponseStructure<Object> responseStructure=new ResponseStructure<>();
		if (findUserByEmailAndPassword!=null) {
			responseStructure.setData(findUserByEmailAndPassword);
			responseStructure.setHttpcode(HttpStatus.FOUND.value());
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			responseStructure.setMessage("USER FOUNDED");
		}
		else {
			responseStructure.setData(findUserByEmailAndPassword);
			responseStructure.setHttpcode(HttpStatus.NOT_FOUND.value());
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			responseStructure.setMessage("USER NOT FOUNDED");
		}
		
		return responseStructure;
	}
	
	
	@GetMapping("/finduserbymobileandpassword")
	public Object  findUserByMobileAndPassword(@RequestParam(name="mobile") Long mobile, @RequestParam(name="password") String password) {
		Object findUserByEmailAndPassword = services.findUserByMobileAndPassword(mobile,password);
		ResponseStructure<Object> responseStructure=new ResponseStructure<>();
		if (findUserByEmailAndPassword!=null) {
			responseStructure.setData(findUserByEmailAndPassword);
			responseStructure.setHttpcode(HttpStatus.FOUND.value());
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			responseStructure.setMessage("USER FOUNDED");
		}
		else {
			responseStructure.setData(findUserByEmailAndPassword);
			responseStructure.setHttpcode(HttpStatus.NOT_FOUND.value());
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			responseStructure.setMessage("USER NOT FOUNDED");
		}
		
		return responseStructure;
	}
	
}
