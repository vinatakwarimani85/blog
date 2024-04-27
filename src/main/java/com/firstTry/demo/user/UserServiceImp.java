package com.firstTry.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firstTry.demo.exceptions.ResourceNotFoundException;
import com.firstTry.demo.uttils.Validation;

import jakarta.validation.ValidationException;


@Component
public class UserServiceImp implements UserService {

	@Autowired
	private Validation validate;

	public UserServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}
    @Autowired
	private UserRepository userRepo;
    
    @Autowired
    private UserDto userdto;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		System.out.println(validate + "012929128182178.......................................");
		User user =userdto.dtoToUser(userDto);
		User savedUser =userRepo.save(user);
//		userDto.setName(" ");
//		if(!validate.validateName(userDto.getName())) {
//			throw new ValidationException("USername");
//		}
		
		return userdto.userToUserDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto,int userId) {
		// TODO Auto-generated method stub
	    User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
	    user.setId(userId);
	    if (userDto.getName()!= null) {
	    	if(!validate.validateName(userDto.getName())) {
	    		throw new com.firstTry.demo.exceptions.ValidationException("UserName");
	    	}else
	    	user.setName(userDto.getName());
	    }
	      
	    if(userDto.getEmail()!=null)
	      user.setEmail(userDto.getEmail());
	    if(userDto.getPassword()!=null)
	      user.setPassword(userDto.getPassword());
	    if(userDto.getAbout()!=null)
	      user.setAbout(userDto.getAbout());
	    User saveduser = userRepo.save(user);
		return userDto.userToUserDto(saveduser);
	}

	@Override
	public UserDto getUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
		
		return userdto.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> listOfUsers = userRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for(User user:listOfUsers)
		{
		   userDtoList.add(userdto.userToUserDto(user));	
		}
		return userDtoList;
	}

	@Override
	public void deleteUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new com.firstTry.demo.exceptions.ResourceNotFoundException("User", "UserId", userId));
		userRepo.delete(user);
	}


}
