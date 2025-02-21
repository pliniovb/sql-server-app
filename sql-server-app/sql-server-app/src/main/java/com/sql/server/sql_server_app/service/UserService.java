package com.sql.server.sql_server_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.server.sql_server_app.entities.User;
import com.sql.server.sql_server_app.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	public User updateUser(Long id, User userDetails) {
		return userRepository.findById(id)
				.map(user ->{
					user.setName(userDetails.getName());
					user.setEmail(userDetails.getEmail());
					return userRepository.save(user);
							
				}).orElseThrow(() -> new RuntimeException("User not found!"));
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
