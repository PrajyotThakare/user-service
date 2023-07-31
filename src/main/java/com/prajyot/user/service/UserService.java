package com.prajyot.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prajyot.user.entity.UserEntity;

@Service
public interface UserService {

	public UserEntity createUser(UserEntity user);

	Optional<UserEntity> findById(Long id);

	List<UserEntity> findByAge(Integer age);

	UserEntity updateUserDetails(UserEntity userDetails);
}
