package com.firstTry.demo.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.firstTry.demo.posts.Post;
import com.firstTry.demo.uttils.Validation;

//import com.firstTry.demo.uttils.*;

import jakarta.validation.ValidationException;

@Component
@ComponentScan("com.firstTry.demo.uttils.Validation")
public class UserDto {


	private int id;

	@NotEmpty
	@Size(min = 4,message = "Name Should Contins  At Least 4 Charecters")
	private String name;

	@NotEmpty
	@Email
	@Pattern(regexp ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	private String email;

	@NotEmpty
	@Size(min =4,max=10,message = "Password Must be min 3 Charecters and max 10 charecters")
	private String password;

	@NotEmpty
	private String about;
	
	
	
	

	@Autowired
	private Validation validate;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
//	public UserDto(Validation validate) {
//		super();
//		this.validate = validate;
//	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
			this.name = name;
		
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public User dtoToUser(UserDto userdto) {
		User user= new User();
		System.out.println("==================Inside Dto===============================");
		if(!validate.validateName(userdto.getName()))
		{
			throw new com.firstTry.demo.exceptions.ValidationException("UserName");
		}
		return this.modelMapper.map(userdto,User.class);
	}
	
	
	public UserDto userToUserDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

}
