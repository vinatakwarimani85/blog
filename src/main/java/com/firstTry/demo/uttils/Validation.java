package com.firstTry.demo.uttils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;

@Component
public class Validation {
	

	public boolean validateName(String name) {
		System.out.println("$$$$$$$$$$$$$$$$$$$"+name  +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		if(name.equals("")) {
			return false;
		}
		if(name.equals(null)) {
			return false;
		}
		try {
		 String regex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		 return name.matches(regex);
		}
		catch (Exception e) {
			throw new ValidationException("UserName");
		}
		
		
	
		
	}

	public Validation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
