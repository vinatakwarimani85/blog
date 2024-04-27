package com.firstTry.demo.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,int id);
	UserDto getUser(int userId);
	List<UserDto> getAllUsers();
	void deleteUser(int userId);


}

