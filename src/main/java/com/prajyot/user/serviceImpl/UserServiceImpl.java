package com.prajyot.user.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prajyot.user.entity.UserEntity;
import com.prajyot.user.repository.UserRepository;
import com.prajyot.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserEntity createUser(UserEntity user) {
		return userRepo.save(user);
	}
	
	@Override
	public Optional<UserEntity> findById(Long id) {
		return userRepo.findById(id);
	}
	
	@Override
	public List<UserEntity> findByAge(Integer age) {
		return userRepo.findByAge(age);
	}

	@Override
	public UserEntity updateUserDetails(UserEntity userDetails) {
		return userRepo.save(userDetails);
	}
}
