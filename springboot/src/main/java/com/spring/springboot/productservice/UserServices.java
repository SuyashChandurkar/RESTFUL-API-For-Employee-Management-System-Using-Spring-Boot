package com.spring.springboot.productservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.pojo.User;
import com.spring.springboot.productrepository.UserRepository;

@Service
public class UserServices {

	@Autowired
private UserRepository repository;

	public User addUser(User user) {
	if (user != null) {
		return	repository.save(user);
	} else {
		return null;
	}
		
	}

	public Object findUserById(long userId) {
		 Optional<User> findById = repository.findById(userId);
		 if (findById.isPresent()) {
			return findById.get();
		}
		 else {
			return null;
		}
		
	}

	public Object findUserByEmailAndPassword(String email, String password) {
		User findUserByEmailAndPassword = repository.findUserByEmailAndPassword(email, password);
		
		if (findUserByEmailAndPassword!=null) {
			return findUserByEmailAndPassword;
		}else {
			return null;
			
		}
	}

	public Object findUserByMobileAndPassword(Long mobile, String password) {
		User findUserByMobileAndPassword = repository.findUserByMobileAndPassword(mobile, password);
		if (findUserByMobileAndPassword!=null) {
			return findUserByMobileAndPassword;
		}else {
			return null;
		}
		
		
	}
	
	
}
