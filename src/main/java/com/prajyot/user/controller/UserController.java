package com.prajyot.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.user.entity.UserEntity;
import com.prajyot.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/findById/{id}")
	public Optional<UserEntity> getUserById(@PathVariable Long id) {
		
		return userService.findById(id);
	}
	
	@GetMapping("/findByAge/{age}")
	public List<UserEntity> getUserById(@PathVariable Integer age) {	
		return userService.findByAge(age);
	}
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserEntity userDetails) {
//		UserEntity userDetails = new UserEntity();
//		userDetails.setId(inDTO.getId());
//		userDetails.setAge(inDTO.getAge());
//		userDetails.setCreatedBy(inDTO.getCreatedBy());
//		userDetails.setAddress(inDTO.getAddress());
//		userDetails.setEmail(inDTO.getEmail());
//		userDetails.setFirstName(inDTO.getFirstName());
//		userDetails.setLastName(inDTO.getLastName());
//		userDetails.setModifiedBy(inDTO.getModifiedBy());
//		userDetails.setPhoneNo(inDTO.getPhoneNo());
		return userService.createUser(userDetails); 
	}
	
	@PutMapping("/update")
	public UserEntity updateUser(@RequestBody UserEntity userDetails) {
		return userService.updateUserDetails(userDetails);
	}
}
